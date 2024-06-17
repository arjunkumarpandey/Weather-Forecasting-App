package com.example.weatherforcastingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import com.example.weatherforcastingapp.databinding.ActivityMainBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fetchWeatherData("New Delhi");
        searchCity();
    }

    private void searchCity() {
        SearchView searchView = binding.searchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null && !query.isEmpty()){
                    fetchWeatherData(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void fetchWeatherData(String cityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<WeatherApp> response = apiInterface.getWeatherData(cityName, "7957ed11cd44aee18f1dbca28be328eb", "metric");

        response.enqueue(new Callback<WeatherApp>() {
            @Override
            public void onResponse(Call<WeatherApp> call, Response<WeatherApp> response) {
                WeatherApp responseBody = response.body();
                if (response.isSuccessful() && responseBody != null) {
                    String temperature = String.valueOf(responseBody.getMain().getTemp());
                    int humidity = responseBody.getMain().getHumidity();
                    double windSpeed = responseBody.getWind().getSpeed();
                    long sunRise = responseBody.getSys().getSunrise();
                    long sunSet = responseBody.getSys().getSunset();
                    int seaLevel = responseBody.getMain().getPressure();
                    String condition = responseBody.getWeather().isEmpty() ? "unknown" : responseBody.getWeather().get(0).getMain();

                    binding.temp.setText(temperature + " °C");
                    binding.weather.setText(condition);
                    binding.humidity.setText(humidity + " %");
                    binding.wind.setText(windSpeed + " m/s");
                    binding.sunrise.setText(time(sunRise));
                    binding.sunset.setText(time(sunSet));
                    binding.sea.setText(seaLevel + " hPa");
                    binding.condition.setText(condition);
                    binding.day.setText(dayName(System.currentTimeMillis()));
                    binding.date.setText(date());
                    binding.cityName.setText(cityName);

                    changeImageAccordingToWeatherCondition(condition);
                }
            }

            @Override
            public void onFailure(Call<WeatherApp> call, Throwable t) {
                Log.e("TAG", "Failed to fetch weather data: " + t.getMessage(), t);
            }
        });
    }

    private void changeImageAccordingToWeatherCondition(String conditions) {
        switch (conditions) {
            case "Clear Sky":
            case "Sunny":
            case "Clear":
                binding.getRoot().setBackgroundResource(R.drawable.sunny_background);
                binding.lottieAnimationView.setAnimation(R.raw.sun);
                break;
            case "Haze":
            case "Partly Clouds":
            case "Clouds":
            case "Overcast":
            case "Mist":
            case "Foggy":
                binding.getRoot().setBackgroundResource(R.drawable.colud_background);
                binding.lottieAnimationView.setAnimation(R.raw.cloud);
                break;
            case "Light Rain":
            case "Drizzle":
            case "Moderate Rain":
            case "Showers":
            case "Heavy Rain":
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            case "Light Snow":
            case "Moderate Snow":
            case "Heavy Snow":
            case "Blizzard":
                binding.getRoot().setBackgroundResource(R.drawable.snow_background);
                binding.lottieAnimationView.setAnimation(R.raw.snow);
                break;
            default:
                binding.getRoot().setBackgroundResource(R.drawable.sunny_background);
                binding.lottieAnimationView.setAnimation(R.raw.sun);
                break;
        }
        binding.lottieAnimationView.playAnimation();
    }

    private String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return sdf.format(new Date());
    }

    private String time(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp * 1000));
    }

    private String dayName(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        return sdf.format(new Date());
    }
}