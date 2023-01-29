package com.tenmafrank.projectwife.ui.configs

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.userpreferences.UserAplication.Companion.userData
import com.tenmafrank.projectwife.utils.Constants

class ConfigsViewModel : ViewModel() {

    private val TAG = "Configs"

    fun setRegister(userName: String, userBday: String, userGender: String, soName: String,
                    soBday: String, soGender: String, soWeight: String, soHeight: String,
                    soBust: String, soWaist: String, soHip: String, soPersonality: String,
                    soBloodType: String, soNickname: String, userNickname: String): String{

        var res = Constants.INCOMPLETE

        if (userName.isEmpty() || userBday.isEmpty() || userGender.isEmpty() || soName.isEmpty()
            || soBday.isEmpty() || soGender.isEmpty() || soWeight.isEmpty() || soHeight.isEmpty() ||
                soBust.isEmpty() || soWaist.isEmpty() || soHip.isEmpty() || soPersonality.isEmpty()
            || soBloodType.isEmpty()){
            res = Constants.INCOMPLETE
        }
        else {
            if (userName.contains(Constants.SPECIAL_CHARS_REG) ||
                soName.contains(Constants.SPECIAL_CHARS_REG) ||
                !soWeight.contains(Constants.ONLY_NUMBERS_REG) ||
                !soHeight.contains(Constants.ONLY_NUMBERS_REG) ||
                !soBust.contains(Constants.ONLY_NUMBERS_REG) ||
                !soWaist.contains(Constants.ONLY_NUMBERS_REG) ||
                !soHip.contains(Constants.ONLY_NUMBERS_REG) ||
                soNickname.contains(Constants.SPECIAL_CHARS_REG) ||
                userNickname.contains(Constants.SPECIAL_CHARS_REG)){
                val dum = soName.contains(Constants.SPECIAL_CHARS_REG)
                val dum2 = !soWeight.contains(Constants.ONLY_NUMBERS_REG)
                res = Constants.INVALID_CHARS
            }
            else{
                val uname = userName.replace("\\s".toRegex(), "").lowercase()
                val sname = soName.replace("\\s".toRegex(), "").lowercase()
                val unick = userNickname.replace("\\s".toRegex(), "").lowercase()
                val snick = soNickname.replace("\\s".toRegex(), "").lowercase()
                if (uname == "frantenma" && sname == "gabrieltenmawhite"){
                    with(userData){
                        setUserName(Constants.GAB_USER_NAME)
                        setUserBday(Constants.MY_BDAY)
                        setUserGender(Constants.MY_GENDER)
                        setSoName(Constants.GAB_SO_NAME)
                        setSoBday(Constants.GAB_BDAY)
                        setSoGender(Constants.GAB_GENDER)
                        setSoWeightSize(Constants.GAB_SO_WEIGHT)
                        setSoHeight(Constants.GAB_SO_HEIGHT)
                        setSoBustSize(Constants.GAB_SO_BUST)
                        setSoWaistSize(Constants.GAB_SO_WAIST)
                        setSoHipSize(Constants.GAB_SO_HIP)
                        setSoPersonalitySize(Constants.GAB_SO_PERSONALTY)
                        setSoBloodType(Constants.GAB_SO_BLOOD)
                        setSoNickname(Constants.GAB_SO_NICKNAME)
                        setUserNickname(Constants.GAB_USER_NICKNAME)
                        setScore(Constants.GAB_SCORE)
                        setRegister(true)
                        setSpecialRegister(true)
                        res = Constants.SPECIAL_USER
                    }
                }
                else{
                    if (sname==Constants.NAME_1 || sname==Constants.NAME_2 || sname==Constants.NAME_3
                        || sname==Constants.NAME_4 || sname==Constants.NAME_5 || sname==Constants.NAME_6
                        || sname==Constants.NAME_7 || sname==Constants.NAME_8 || sname==Constants.NAME_9
                        || sname==Constants.NAME_10 || sname==Constants.NAME_11 || sname==Constants.NAME_12
                        || sname==Constants.NAME_13 || sname==Constants.NAME_14 || sname==Constants.NAME_15
                        || snick==Constants.NAME_1 || snick==Constants.NAME_2 || snick==Constants.NAME_3
                        || snick==Constants.NAME_4 || snick==Constants.NAME_5 || snick==Constants.NAME_6
                        || snick==Constants.NAME_7 || snick==Constants.NAME_8 || snick==Constants.NAME_9
                        || snick==Constants.NAME_10 || snick==Constants.NAME_11 || snick==Constants.NAME_12
                        || snick==Constants.NAME_13 || snick==Constants.NAME_14 || snick==Constants.NAME_15){
                        res = Constants.FORBIDDEN_NAME
                    }
                    else{
                        with(userData){
                            setUserName(userName)
                            setUserBday(userBday)
                            setUserGender(userGender)
                            setSoName(soName)
                            setSoBday(soBday)
                            setSoGender(soGender)
                            setSoWeightSize(soWeight)
                            setSoHeight(soHeight)
                            setSoBustSize(soBust)
                            setSoWaistSize(soWaist)
                            setSoHipSize(soHip)
                            setSoPersonalitySize(soPersonality)
                            setSoBloodType(soBloodType)
                            setSoNickname(soNickname)
                            setUserNickname(userNickname)
                            setScore(Constants.DEFAULT_SCORE)
                            setRegister(true)
                            setSpecialRegister(false)
                            res = Constants.COMPLETE
                        }
                    }
                }
            }
        }
        return res
    }
}