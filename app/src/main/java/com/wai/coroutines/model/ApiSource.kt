package com.wai.coroutines.model

import com.orhanobut.logger.Logger
import com.wai.coroutines.pojo.BaseData
import com.wai.coroutines.pojo.SatinBean
import com.wai.coroutines.pojo.WeatherData
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface ApiService {

    @GET("weatherApi")
    fun getWeatherData(@Query("city") cityName: String): Call<BaseData<WeatherData>>


    @GET("satinApi")
    fun getSatinData(@Query("type") type: Int, @Query("page") page: Int): Call<MutableList<SatinBean>>


}

class ApiSource {
    companion object {


        private val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            //                .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        @JvmField
        val instance = Retrofit.Builder()
            .baseUrl("https://www.apiopen.top/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}

suspend fun <T> Call<T>.await(): T {
    return suspendCancellableCoroutine {
        it.invokeOnCancellation {
            Logger.d("=========== request cancel ================== ")
            it?.printStackTrace()
            cancel()
        }
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    it.resume(response.body()!!)
                } else {
                    it.resumeWithException(Throwable(response.toString()))
                }
            }
        })
    }
}