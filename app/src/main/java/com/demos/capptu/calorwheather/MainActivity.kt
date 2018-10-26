package com.demos.capptu.calorwheather

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import butterknife.BindDrawable
import butterknife.ButterKnife
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    @BindDrawable(R.drawable.clear_night) lateinit var clearNight : Drawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)


        dailyWeatherTextView.setOnClickListener {
            var dailyActivity = Intent(this,DailyWeatherActivity ::class.java)
            startActivity(dailyActivity)
        }
        hourlyWeatherTextView.setOnClickListener {
            var hourlyActivity = Intent(this,HourlyWeatherActivity ::class.java)
            startActivity(hourlyActivity)
        }
        minutelyWheatherTextView.setOnClickListener {
            var minutelyWeather = Intent(this,MinutelyWeatherActivity ::class.java)
            startActivity(minutelyWeather)
        }

        // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://api.darksky.net/forecast/291c54d72a568ca4bc7dfcf52ad378a2/19.4126342,-99.1647357?units=si"

        // Request a string response from the provided URL.
                val stringRequest = StringRequest(Request.Method.GET, url,
                        Response.Listener<String> { response ->
                            var currentWeather = currentWeatherFromJson(response)

                            iconImageView.setImageDrawable(currentWeather?.iconDrawableResource)
                            descriptionTextView.text = currentWeather?.description
                            currentTempTextView.text = currentWeather?.currentTemperature
                            highestTempTextView.text = "H: ${currentWeather?.highestTemperature}°"
                            lowestTempTextView.text = "L: ${currentWeather?.lowestTemperature}°"

                        },
                        Response.ErrorListener {Log.d("","That didn't work!") })

        // Add the request to the RequestQueue.
                queue.add(stringRequest)
    }

    private fun  currentWeatherFromJson (json:String):CurrentWeather?{
        var jsonObject = JSONObject(json)
        var jsonWithCurrentWeather = jsonObject.getJSONObject("currently")
        var jsonWithDailyWeather = jsonObject.getJSONObject("daily")

        var jsonWithDailyWeatherData :JSONArray = jsonWithDailyWeather.getJSONArray("data")
        var jsonWithTodayData : JSONObject = jsonWithDailyWeatherData.getJSONObject(0)

        var summary = jsonWithCurrentWeather.getString("summary")
        var icon = jsonWithCurrentWeather.getString("icon")
        var temperature = Math.round(jsonWithCurrentWeather.getDouble("temperature")).toString()
        var maxTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMax")).toString()
        var minTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMin")).toString()

        var currentWeather = CurrentWeather(this)
        currentWeather.description = summary
        currentWeather.iconImage = icon
        currentWeather.currentTemperature = temperature
        currentWeather.highestTemperature = maxTemperature
        currentWeather.lowestTemperature = minTemperature
        return  currentWeather
    }
}
