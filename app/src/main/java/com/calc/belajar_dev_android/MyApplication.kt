package com.calc.belajar_dev_android

import android.app.Application
import android.util.Log

class MyApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        Log.i("App", "Application created")
    }

}