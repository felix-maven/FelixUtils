package com.felix.utils.widget.dialog

import android.app.ProgressDialog
import android.content.Context

/**
 * @Author: Mingfa.Huang
 * @Date: 2020/8/16
 * @Des: ILoadDialog
 */
interface ILoadDialog {
    var ctx: Context?
    var progressDialog: ProgressDialog?

    fun showLoading(content: String) {
        (progressDialog ?: kotlin.run {
            ProgressDialog(ctx).also {
                it.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            }
        }).also {
            progressDialog = it
        }.also {
            it.setMessage(content)
        }.show()
    }

    fun dismissLoading() {
        progressDialog?.dismiss()
    }
}