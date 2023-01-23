package com.tenmafrank.projectwife.ui.slideshow

import android.util.Log
import androidx.lifecycle.ViewModel

class ConfigsViewModel : ViewModel() {

    private val TAG = "Configs"

    fun setRegister(userName: String, userBday: String, userGender: String, soName: String,
                    soBday: String, soGender: String, soWeight: String, soHeight: String,
                    soBust: String, soWaist: String, soHip: String, soPersonality: String,
                    soBloodType: String, soNickname: String, userNickname: String) : Boolean{
        Log.d(TAG,userName + userBday + userGender)
        return true
    }
}