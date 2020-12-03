package com.felix.felixutils.utils

interface ITAG {
    val TAG: String
        get() = this::class.java.simpleName
}