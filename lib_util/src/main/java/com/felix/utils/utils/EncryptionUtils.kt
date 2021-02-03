package com.felix.utils.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * @Author: Mingfa.Huang
 * @Date: 2021/2/2
 * @Des: EncryptionUtils
 */

fun String.md5(): String {
    val hash: ByteArray
    hash = try {
        MessageDigest.getInstance("MD5").digest(this.toByteArray(charset("UTF-8")))
    } catch (e: NoSuchAlgorithmException) {
        throw RuntimeException("NoSuchAlgorithmException", e)
    } catch (e: UnsupportedEncodingException) {
        throw RuntimeException("UnsupportedEncodingException", e)
    }
    val hex = StringBuilder(hash.size * 2)
    for (b in hash) {
        if (b.toInt() and 0xFF < 0x10) {
            hex.append("0")
        }
        hex.append(Integer.toHexString(b.toInt() and 0xFF))
    }
    return hex.toString()
}