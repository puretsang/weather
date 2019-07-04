package com.wai.coroutines.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import com.wai.coroutines.BaseApplication

object ToastShow {

    private var oldMsg = ""
    private var toast: Toast? = null
    private var oneTime: Long = 0
    private var twoTime: Long = 0

    private fun showToast(context: Context?, s: String?) {
        var s = s
        if (null == context) return
        if (s == null) s = "未知错误"
        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT)
            toast!!.setGravity(Gravity.CENTER, 0, 0)
            toast!!.show()
            oneTime = System.currentTimeMillis()
        } else {
            twoTime = System.currentTimeMillis()
            if (s == oldMsg) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast!!.show()
                }
            } else {
                oldMsg = s
                toast!!.setText(s)
                toast!!.show()
            }
        }
        oneTime = twoTime
    }


    fun showToast(s: String) {
        showToast(BaseApplication.instance, s)
    }
}
