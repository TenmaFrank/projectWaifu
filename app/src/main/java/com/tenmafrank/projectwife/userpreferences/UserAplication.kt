package com.tenmafrank.projectwife.userpreferences

import android.app.Application

class UserAplication: Application() {
    companion object{
        lateinit var userData: UserPreferences
    }

    override fun onCreate() {
        super.onCreate()
        userData = UserPreferences(applicationContext)
    }
}