package com.felix.utils.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felix.lib_app_tools.toast.ToastDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastDelegate.show("this is test")
        tvTest.setOnClickListener {
            ToastDelegate.show("on Click")
        }
    }
}