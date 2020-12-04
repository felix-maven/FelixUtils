package com.felix.lib_app_tools.toast

import android.view.Gravity
import android.widget.Toast
import com.felix.utils.AppDelegate
import com.felix.utils.handler.UIDelegate

internal class ToastManager private constructor() : IToast {
    companion object {
        val instance: ToastManager by lazy {
            ToastManager()
        }
    }

    private lateinit var toast: Toast

    init {
        UIDelegate.post {
            toast = Toast(AppDelegate)
        }
    }

    override fun show(msg: String?, duration: Int, gravity: Int) {
        msg?.takeIf { it.isNotEmpty() }?.let {
            UIDelegate.post {
                toast.setText(msg)
                toast.duration = duration
                toast.setGravity(gravity, 0, 0)
                toast.show()
            }
        }
    }

    override fun show(resId: Int, duration: Int, gravity: Int) {
        resId.takeIf { it > 0 }?.let {
            UIDelegate.post {
                toast.setText(resId)
                toast.duration = duration
                toast.setGravity(gravity, 0, 0)
                toast.show()
            }
        }
    }
}

val ToastDelegate: IToast
    get() = ToastManager.instance

fun String.showToast(duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.CENTER) {
    ToastDelegate.show(this, duration, gravity)
}