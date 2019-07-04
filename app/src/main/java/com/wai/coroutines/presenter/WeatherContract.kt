package com.wai.coroutines.presenter

import com.wai.coroutines.base.MvpPresenter
import com.wai.coroutines.base.MvpView
import com.wai.coroutines.pojo.WeatherData

class WeatherContract {

    interface View: MvpView {
        fun showLoadingView()
        fun showLoadingSuccessView(data: WeatherData?)
        fun showLoadingErrorView()
    }

    interface Presenter: MvpPresenter<View> {
        fun retrofitCoroutine(cityName :String)
    }
}