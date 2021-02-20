package com.felix.utils.widget.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

/**
 * @Author: Mingfa.Huang
 * @Date: 2021/2/20
 * @Des: IInfoDialog
 */
interface IInfoDialog {
    var ctx: Context?
    var dialog: AlertDialog?

    fun showInfo(content: String) {
        (dialog ?: AlertDialog.Builder(ctx).create().apply {
            setButton(DialogInterface.BUTTON_POSITIVE, "确定", { dialog, which ->
                dismiss()
            })
        }).also {
            it.setMessage(content)
        }.show()
    }

    fun dismissInfo() {
        dialog?.dismiss()
    }
}