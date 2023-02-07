package com.tenmafrank.projectwife.utils

import android.content.Context
import android.widget.Toast

class Toaster {
    /**
     * makeAToast
     * Description: requires context and message, can use to show massages trough toast
     * 07:17 p. m.
     * TenmaFran
     **/
    fun makeAToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}