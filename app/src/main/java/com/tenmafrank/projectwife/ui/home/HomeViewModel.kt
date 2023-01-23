package com.tenmafrank.projectwife.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tenmafrank.projectwife.userpreferences.UserAplication.Companion.userData

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = userData.getUserName()
    }
    val text: LiveData<String> = _text
}