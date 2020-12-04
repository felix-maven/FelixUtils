package com.felix.utils

import android.app.Application

/**
 * @Author: Mingfa.Huang
 * @Date: 2020/11/28
 * @Des: AppSetup
 */
object AppUtils {
    fun setup(application: Application) {
        AppDelegate = application
    }
}

lateinit var AppDelegate: Application