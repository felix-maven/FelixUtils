package com.felix.felixutils.ext

import android.os.Parcel
import android.os.Parcelable

/**
 * @Author: Mingfa.Huang
 * @Date: 2020/11/29
 * @Des: ParcelableExt
 */

fun <T : Parcelable> Parcelable.copy(): T? {
    var parcel: Parcel? = null
    try {
        return Parcel.obtain()
            .also { parcel = it }
            .also {
                it.writeParcelable(this, 0)
                it.setDataPosition(0)
            }.readParcelable(this::class.java.classLoader)
    } finally {
        parcel?.recycle()
    }
}