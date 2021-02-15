package com.felix.utils.app

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.felix.lib_app_tools.toast.ToastDelegate
import com.felix.utils.utils.ITAG
import com.felix.utils.utils.RSAUtils
import com.felix.utils.utils.encryption.aes
import com.felix.utils.utils.encryption.decAes
import com.felix.utils.utils.md5
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey


class MainActivity : AppCompatActivity(), ITAG {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastDelegate.show("this is test")
        tvTest.setOnClickListener {
            rsaTest()
        }
    }

    fun md5Test() {
        "123456".md5().also {
            Log.i(TAG, "onCreate: $it")
        }
    }

    fun aesTest() {
        val data = "hello 我是一根葱"
        val key = "150830"
        data.aes(key).also {
            Log.i(TAG, "onCreate: $it")
        }?.decAes(key)?.also {
            Log.i(TAG, "onCreate: $it")
        }

        "y3MW2Ij2Yw87aq1cx2VA83if7k1nAKrSDnPJZ0+LRMY=".decAes("150830").also {
            Log.i(TAG, "onCreate: $it")
        }
    }

    fun rsaTest() {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        val map: HashMap<String, Any> = RSAUtils.getKeys()
        //生成公钥和私钥
        //生成公钥和私钥
        val publicKey: RSAPublicKey = map["public"] as RSAPublicKey
        val privateKey: RSAPrivateKey = map["private"] as RSAPrivateKey

        //模

        //模
        val modulus: String = publicKey.getModulus().toString()
        println(modulus)
        //公钥指数
        //公钥指数
        val public_exponent: String = publicKey.getPublicExponent().toString()
        //私钥指数
        //私钥指数
        val private_exponent: String = privateKey.getPrivateExponent().toString()

        println("公钥指数:$public_exponent")

        println("私钥指数:$private_exponent")


        //明文


        //明文
        val ming = "123456789 Hello 小笨蛋"
        //使用模和指数生成公钥和私钥
        //使用模和指数生成公钥和私钥
        val pubKey: RSAPublicKey = RSAUtils.getPublicKey(modulus, public_exponent)
        val priKey: RSAPrivateKey = RSAUtils.getPrivateKey(modulus, private_exponent)


        //加密后的密文


        //加密后的密文
        val mi: String = RSAUtils.encryptByPublicKey(ming, pubKey)
        println("加密后的密文$mi")
        //解密后的明文
        //解密后的明文
        val mingn: String = RSAUtils.decryptByPrivateKey(mi, priKey)
        println("解密后的明文$mingn")
    }
}