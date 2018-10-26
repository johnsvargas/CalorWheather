package com.demos.capptu.calorwheather;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import butterknife.BindDrawable;
import butterknife.ButterKnife;

public class CurrentWeather {
    public static final String CLEAR_NIGHT = "clear-night";
    public static final String CLEAR_DAY = "clear-day";
    public static final String CLOUDY = "cloudy";
    public static final String PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";
    public static final String FOG = "fog";
    public static final String NA = "na";
    public static final String PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    public static final String RAIN = "rain";
    public static final String SLEET = "sleet";
    public static final String SNOW = "snow";
    public static final String SUNNY = "sunny";
    public static final String WIND = "wind";

    @BindDrawable(R.drawable.clear_night) Drawable clearNight;
    @BindDrawable(R.drawable.clear_day) Drawable clearDay;
    @BindDrawable(R.drawable.cloudy) Drawable cloudy;
    @BindDrawable(R.drawable.cloudy_night) Drawable cloudyNight;
    @BindDrawable(R.drawable.fog) Drawable fog;
    @BindDrawable(R.drawable.na) Drawable na;
    @BindDrawable(R.drawable.partly_cloudy) Drawable partlyCloudy;
    @BindDrawable(R.drawable.rain) Drawable rain;
    @BindDrawable(R.drawable.sleet) Drawable sleet;
    @BindDrawable(R.drawable.snow) Drawable snow;
    @BindDrawable(R.drawable.sunny) Drawable sunny;
    @BindDrawable(R.drawable.wind) Drawable wind;


     private String description;
     private String currentTemperature;
     private String lowestTemperature;
     private String highestTemperature;
     private String iconImage;

     public CurrentWeather(Activity activity){
         ButterKnife.bind(this,activity);
     }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getLowestTemperature() {
        return lowestTemperature;
    }

    public void setLowestTemperature(String lowestTemperature) {
        this.lowestTemperature = lowestTemperature;
    }

    public String getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(String highestTemperature) {
        this.highestTemperature = highestTemperature;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public Drawable getIconDrawableResource(){

        switch (iconImage) {
            case CLEAR_NIGHT:
                return clearNight;
            case CLEAR_DAY:
                return clearDay;
            case CLOUDY:
                return cloudy;
            case PARTLY_CLOUDY_NIGHT:
                return cloudyNight;
            case FOG:
                return fog;
            case NA:
                return na;
            case PARTLY_CLOUDY_DAY:
                return partlyCloudy;
            case RAIN:
                return rain;
            case SLEET:
                return sleet;
            case SNOW:
                return snow;
           case SUNNY:
                return sunny;
            case WIND:
                return wind;
            default:
                return na;

        }

    }
}
