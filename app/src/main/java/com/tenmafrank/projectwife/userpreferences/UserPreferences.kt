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

    fun setSpecialRegister(special: Boolean){
        enSharedPreferences.edit().putBoolean(Constants.SPECIAL_USER, special).apply()
    }
    fun getSpecialRegister(): Boolean{
        return enSharedPreferences.getBoolean(Constants.SPECIAL_USER, false)!!
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
    fun setSoGender(gender: String){
        enSharedPreferences.edit().putString(Constants.SO_GENDER_KEY,gender).apply()
    }
    fun getSoGender(): String{
        return enSharedPreferences.getString(Constants.SO_GENDER_KEY,Constants.DEFAULT_GENDER)!!
    }
    //so height
    fun setSoHeight(height : String){
        enSharedPreferences.edit().putString(Constants.SO_HEIGHT_KEY,height).apply()
    }
    fun getSoHeight(): String{
        return enSharedPreferences.getString(Constants.SO_HEIGHT_KEY,Constants.DEFAULT_SO_HEIGHT)!!
    }
    //so height size
    fun setSoWeightSize(size : String){
        enSharedPreferences.edit().putString(Constants.SO_WEIGHT_KEY,size).apply()
    }
    fun getSoWeightSize(): String{
        return enSharedPreferences.getString(Constants.SO_WEIGHT_KEY,Constants.DEFAULT_SO_WEIGHT)!!
    }
    //so bust size
    fun setSoBustSize(size : String){
        enSharedPreferences.edit().putString(Constants.SO_BUST_KEY,size).apply()
    }
    fun getSoBustSizet(): String{
        return enSharedPreferences.getString(Constants.SO_BUST_KEY,Constants.DEFAULT_SO_BUST)!!
    }
    //so waist size
    fun setSoWaistSize(size : String){
        enSharedPreferences.edit().putString(Constants.SO_WAIST_KEY,size).apply()
    }
    fun getSoWaistSize(): String{
        return enSharedPreferences.getString(Constants.SO_WAIST_KEY,Constants.DEFAULT_SO_WAIST)!!
    }
    //so hip size
    fun setSoHipSize(size : String){
        enSharedPreferences.edit().putString(Constants.SO_HIP_KEY,size).apply()
    }
    fun getSoHipSize(): String{
        return enSharedPreferences.getString(Constants.SO_HIP_KEY,Constants.DEFAULT_SO_HIP)!!
    }
    //so personality
    fun setSoPersonalitySize(personality : String){
        enSharedPreferences.edit().putString(Constants.SO_PERSONALTY_KEY,personality).apply()
    }
    fun getSoPersonalitySize(): String{
        return enSharedPreferences.getString(Constants.SO_PERSONALTY_KEY,Constants.DEFAULT_SO_PERSONALTY)!!
    }
    //so blood type
    fun setSoBloodType(type : String){
        enSharedPreferences.edit().putString(Constants.SO_BLOOD_KEY,type).apply()
    }
    fun getSoBloodType(): String{
        return enSharedPreferences.getString(Constants.SO_BLOOD_KEY,Constants.DEFAULT_SO_BLOOD)!!
    }
    //so nickname
    fun setSoNickname(name : String){
        enSharedPreferences.edit().putString(Constants.SO_NICKNAME_KEY,name).apply()
    }
    fun getSoNickname(): String{
        return enSharedPreferences.getString(Constants.SO_NICKNAME_KEY,Constants.DEFAULT_SO_NICKNAME)!!
    }
    //user nickname
    fun setUserNickname(name : String){
        enSharedPreferences.edit().putString(Constants.USER_NICKNAME_KEY,name).apply()
    }
    fun getUserNickname(): String{
        return enSharedPreferences.getString(Constants.USER_NICKNAME_KEY,Constants.DEFAULT_USER_NICKNAME)!!
    }
    //score
    fun setScore(score: Int){
        enSharedPreferences.edit().putInt(Constants.SCORE_KEY,score).apply()
    }
    fun getScore(): Int{
        return enSharedPreferences.getInt(Constants.SCORE_KEY, Constants.DEFAULT_SCORE)
    }
    //all data entered (is register)
    fun setRegister(final : Boolean){
        enSharedPreferences.edit().putBoolean(Constants.REGISTER_KEY,final).apply()
    }
    fun getRegister(): Boolean{
        return enSharedPreferences.getBoolean(Constants.REGISTER_KEY, false)
    }
    //pic of your waifu
    fun setPicWaifu(uri: String){
        enSharedPreferences.edit().putString(Constants.PIC_URI_KEY, uri).apply()
    }
    fun getPicWaifu():String{
        return enSharedPreferences.getString(Constants.PIC_URI_KEY,"")!!
    }
}