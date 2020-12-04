package com.felix.utils.handler

import android.os.Handler
import android.os.Looper

val UIDelegate by lazy {
    Handler(Looper.getMainLooper())
}