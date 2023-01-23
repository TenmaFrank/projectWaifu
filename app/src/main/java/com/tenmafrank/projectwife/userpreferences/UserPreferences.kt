package com.tenmafrank.projectwife.userpreferences

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.utils.Constants

class UserPreferences(context: Context) {

    private val enSharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        Constants.PREFERENCES_KEY,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    //user datas
    //user name
    fun setUserName(name: String){
        enSharedPreferences.edit().putString(Constants.USER_NAME_KEY, name).apply()
    }

    fun getUserName(): String{
        return enSharedPreferences.getString(Constants.USER_NAME_KEY,
            Constants.DEFAULT_USER_NAME)!!
    }
    //user birthday
    fun setUserBday(bday: String){
        enSharedPreferences.edit().putString(Constants.USER_BDAY_KEY,bday).apply()
    }

    fun getUserBday(): String{
        return enSharedPreferences.getString(Constants.USER_BDAY_KEY,
            Constants.DEFAULT_BDAY)!!
    }
    //user gender
    fun setUserGender(gender: String){
        enSharedPreferences.edit().putString(Constants.USER_GENDER_KEY, gender).apply()
    }

    fun getUserGender(): String{
        return enSharedPreferences.getString(Constants.USER_GENDER_KEY,
            Constants.DEFAULT_GENDER)!!
    }
    //end user data

    //so data
    //so name
    fun setSoName(name: String){
        enSharedPreferences.edit().putString(Constants.SO_NAME_KEY,name).apply()
    }
    fun getSoName(): String{
        return enSharedPreferences.getString(Constants.SO_NAME_KEY,
        Constants.DEFAULT_SO_NAME)!!
    }
    //so birthday
    fun setSoBday(birthday: String){
        enSharedPreferences.edit().putString(Constants.SO_BDAY_KEY,birthday).apply()
    }
    fun getSoBday(): String{
        return enSharedPreferences.getString(Constants.SO_BDAY_KEY,
        Constants.DEFAULT_BDAY)!!
    }
    //so gender

}