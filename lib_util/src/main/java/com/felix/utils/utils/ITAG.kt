package com.felix.utils.utils

interface ITAG {
    val TAG: String
        get() = this::class.java.simpleName
}