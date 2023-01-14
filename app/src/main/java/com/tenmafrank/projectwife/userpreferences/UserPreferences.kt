package com.tenmafrank.projectwife.userpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tenmafrank.projectwife.utils.Constants

class UserPreferences(context: Context) {

    private val enSharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        Constants.PREFERENCES_KEY,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun setNameUser(name: String){
        enSharedPreferences.edit().putString(Constants.USER_NAME_KEY, name).apply()
    }

    fun getNameUser(): String{
        return enSharedPreferences.getString(Constants.USER_NAME_KEY, "<REDACTED>")!!
    }

}