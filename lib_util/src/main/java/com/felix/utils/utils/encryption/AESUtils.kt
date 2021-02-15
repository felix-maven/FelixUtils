package com.felix.utils.utils.encryption

import android.util.Base64
import com.felix.utils.utils.md5
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * @Author: Mingfa.Huang
 * @Date: 2021/2/15
 * @Des: AESUtils
 */

/**
 * AES加密
 */
fun String.aes(sKey: String): String? {
    return sKey.md5()?.let {
        it.toByteArray()
    }?.let {
        SecretKeySpec(it, "AES")
    }.runCatching {
        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
            init(Cipher.ENCRYPT_MODE, this@runCatching)
        }.doFinal(this@aes.toByteArray()).let {
            Base64.encodeToString(it, Base64.DEFAULT)
        }
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()
}

/**
 * AES解密
 */
fun String.decAes(sKey: String): String? {
    return sKey.md5()?.let {
        it.toByteArray()
    }?.let {
        SecretKeySpec(it, "AES")
    }.runCatching {
        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
            init(Cipher.DECRYPT_MODE, this@runCatching)
        }.let {
            it.doFinal(Base64.decode(this@decAes, Base64.DEFAULT))
        }.let {
            String(it)
        }
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()
}

/**
 * AES加密
 */
fun ByteArray.aes(sKey: String): ByteArray? {
    return sKey.md5()?.let {
        it.toByteArray()
    }?.let {
        SecretKeySpec(it, "AES")
    }.runCatching {
        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
            init(Cipher.ENCRYPT_MODE, this@runCatching)
        }.doFinal(this@aes).let {
            Base64.encode(it, Base64.DEFAULT)
        }
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()
}

fun ByteArray.decAes(sKey: String): ByteArray? {
    return sKey.md5()?.let {
        it.toByteArray()
    }?.let {
        SecretKeySpec(it, "AES")
    }.runCatching {
        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
            init(Cipher.DECRYPT_MODE, this@runCatching)
        }.let {
            it.doFinal(Base64.decode(this@decAes, Base64.DEFAULT))
        }
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()
}

//fun File.aes(sKey: String, out: File) {
//    if (!this.exists()) {
//        Log.w("aes", "aes: source file is not exists")
//        return
//    }
//    val cipher = sKey.md5()?.let {
//        it.toByteArray()
//    }?.let {
//        SecretKeySpec(it, "AES")
//    }.runCatching {
//        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
//            init(Cipher.ENCRYPT_MODE, this@runCatching)
//        }
//    }.also {
//        it.exceptionOrNull()?.printStackTrace()
//    }.getOrNull()
//
//    val out = out.apply {
//        if (exists()) {
//            delete()
//        }
//        this.createNewFile()
//    }.outputStream()
//    val input = this.inputStream()
//    val byte = ByteArray(32)
//    try {
//        while (input.read(byte) != -1) {
//            out.write(cipher?.doFinal(Base64.decode(byte, Base64.DEFAULT)) ?: byte)
//        }
//    } catch (e: Throwable) {
//        e.printStackTrace()
//    } finally {
//        input.close()
//        out.close()
//    }
//}
//
//fun File.decAes(sKey: String, outFile: File) {
//    if (!this.exists()) {
//        Log.w("decAes", "decAes: source file is not exists")
//        return
//    }
//    val cipher = sKey.md5()?.let {
//        it.toByteArray()
//    }?.let {
//        SecretKeySpec(it, "AES")
//    }.runCatching {
//        Cipher.getInstance("AES/ECB/PKCS5Padding").apply {
//            init(Cipher.DECRYPT_MODE, this@runCatching)
//        }
//    }.also {
//        it.exceptionOrNull()?.printStackTrace()
//    }.getOrNull()
//    val out = outFile.apply {
//        if (exists()) {
//            delete()
//        }
//        this.createNewFile()
//    }.outputStream()
//    val input = this.inputStream()
//    val byte = ByteArray(32)
//    try {
//        while (input.read(byte) != -1) {
//            out.write(Base64.decode(cipher?.doFinal(byte), Base64.DEFAULT))
//        }
//    } catch (e: Throwable) {
//        e.printStackTrace()
//    } finally {
//        input.close()
//        out.close()
//    }
//}


