package com.wai.coroutines

import android.app.Application

class BaseApplication : Application() {

    companion object{
        var instance : BaseApplication?= null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}