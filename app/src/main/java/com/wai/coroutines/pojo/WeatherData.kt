package com.wai.coroutines.pojo

import com.google.gson.annotations.SerializedName

data class WeatherData(

    @SerializedName("ganmao")
    val description: String,

    val wendu :Double,

    @SerializedName("forecast")
    val list: MutableList<WeatherBean>

)

data class WeatherBean (
    var date: String,
    var high: String,
    var low: String,
    var fengli: String,
    var fengxiang: String,
    var type: String
)



