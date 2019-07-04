package com.wai.coroutines.model.repository

import com.wai.coroutines.model.ApiSource
import com.wai.coroutines.pojo.SatinBean
import com.wai.coroutines.pojo.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

object Repository {


    suspend fun suspendQueryWeather(cityName: String): WeatherData {
        return withContext(Dispatchers.IO) {
            try {
                val deferred = async {
                    val result = ApiSource.instance.getWeatherData(cityName).execute()
                    if (result.isSuccessful) {

                        val data = result.body()!!
                        if (data.code == 200)
                            data
                        else
                            null
                    } else {
                        throw Throwable("android request failure")
                    }
                }

                val result = deferred.await()!!.data
                result

            } catch (e: Throwable) {
                e.printStackTrace()
                throw e
            }
        }
    }

    suspend fun suspendList(type: Int, page: Int): MutableList<SatinBean> {
        return withContext(Dispatchers.IO) {
            try {
                val deferred = async {
                    val result = ApiSource.instance.getSatinData(type, page).execute()
                    if (result.isSuccessful) {
                        val data = result.body()!!
                        if (data.code == 200)
                            data
                        else
                            null
                    } else {
                        throw Throwable("android request failure")
                    }
                }
                val list = deferred.await()!!.data
                list
            } catch (e: Throwable) {
                e.printStackTrace()
                throw e
            }
        }
    }
}