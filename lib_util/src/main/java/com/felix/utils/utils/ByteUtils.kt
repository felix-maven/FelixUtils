package com.felix.utils.utils

import kotlin.experimental.and

/**
 *
 * @ProjectName: FelixUtils
 * @Package: com.felix.utils.utils
 * @ClassName: ByteUtils
 * @Author: 80341341
 * @CreateDate: 2021/7/27 19:53
 * @Description: ByteUtils类作用描述
 */
fun ByteArray.toInt(): Int {
    return this[3].toInt() and 0xFF or (
            this[2].toInt() and 0xFF shl 8) or (
            this[1].toInt() and 0xFF shl 16) or (
            this[0].toInt() and 0xFF shl 24)
}

fun Int.toByteArray(): ByteArray {
    val a = this
    return byteArrayOf(
        (a shr 24 and 0xFF).toByte(),
        (a shr 16 and 0xFF).toByte(),
        (a shr 8 and 0xFF).toByte(),
        (a and 0xFF).toByte()
    )
}






















