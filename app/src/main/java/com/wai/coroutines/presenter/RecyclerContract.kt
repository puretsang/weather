package com.wai.coroutines.presenter

import com.wai.coroutines.base.MvpPresenter
import com.wai.coroutines.base.MvpView
import com.wai.coroutines.pojo.SatinBean
import com.wai.coroutines.pojo.WeatherData

class RecyclerContract {

    interface View: MvpView {
        fun showLoadingSuccessView(data: MutableList<SatinBean>?)
    }

    interface Presenter: MvpPresenter<View> {
        fun retrofitCoroutine(type :Int, page : Int)
    }
}