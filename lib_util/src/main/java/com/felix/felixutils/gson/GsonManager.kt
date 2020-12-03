package com.felix.felixutils.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class GsonManager private constructor() {
    companion object {
        val instance by lazy { GsonManager() }
    }

    val gson: Gson = Gson()
}

val GsonDelegate
    get() = GsonManager.instance.gson

inline fun <T> T.toJson(): String = GsonDelegate.toJson(this) ?: ""
inline fun <reified T> String.fromJson(): T? = GsonDelegate.fromJson<T>(this, object :
    TypeToken<T>() {}.type)