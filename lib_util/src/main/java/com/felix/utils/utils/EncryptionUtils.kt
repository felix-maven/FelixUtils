package com.felix.utils.utils

import android.util.Base64
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


/**
 * @Author: Mingfa.Huang
 * @Date: 2021/2/2
 * @Des: EncryptionUtils
 */

fun String.md5(): String? {
    return this.runCatching {
        MessageDigest.getInstance("MD5").digest(this.toByteArray())
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()?.let { hash ->
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            if (b.toInt() and 0xFF < 0x10) {
                hex.append("0")
            }
            hex.append(Integer.toHexString(b.toInt() and 0xFF))
        }
        hex.toString()
    }
}

