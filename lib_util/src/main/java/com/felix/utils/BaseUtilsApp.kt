package com.felix.utils

import android.app.Application
import android.content.Context

/**
 * @Author: Mingfa.Huang
 * @Date: 2020/11/28
 * @Des: BaseUtilsApp
 */
open class BaseUtilsApp : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        AppUtils.setup(this)
    }
}