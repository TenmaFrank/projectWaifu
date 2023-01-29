package com.tenmafrank.projectwife.utils

import android.content.Context
import android.widget.Toast

class Toaster {
    //requires context and message, cant use to show massages trough toast
    fun makeAToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    //---
}