package com.tenmafrank.projectwife.utils

object Constants {
    //prefrences keys
    const val SEND_ID = "SEND_ID"
    const val RECEIVE_ID = "RECEIVE_ID"
    const val PREFERENCES_KEY = "uPref"
    const val USER_NAME_KEY = "userName"
    const val USER_BDAY_KEY = "userBday"
    const val USER_GENDER_KEY = "userGender"
    const val SO_NAME_KEY = "soName"
    const val SO_BDAY_KEY = "soBday"
    const val SO_GENDER_KEY = "soGender"
    const val SO_HEIGHT_KEY = "soHeight"
    const val SO_WEIGHT_KEY = "soWeight"
    const val SO_BUST_KEY = "soBust"
    const val SO_WAIST_KEY = "soWaist"
    const val SO_HIP_KEY = "soHip"
    const val SO_PERSONALTY_KEY = "soPer"
    const val SO_BLOOD_KEY = "soBlood"
    const val SO_NICKNAME_KEY = "soNick"
    const val USER_NICKNAME_KEY = "userNick"
    const val SCORE_KEY = "score"
    const val REGISTER_KEY = "registed"
    //----

    //default data
    const val DEFAULT_USER_NAME = "Master"
    const val DEFAULT_BDAY = "01/01/2000"
    const val DEFAULT_GENDER = "Female"
    const val DEFAULT_SO_NAME = "Kumiko Akira"
    const val DEFAULT_SO_HEIGHT = "149"
    const val DEFAULT_SO_WEIGHT = "45"
    const val DEFAULT_SO_BUST = "78"
    const val DEFAULT_SO_WAIST = "55"
    const val DEFAULT_SO_HIP = "80"
    const val DEFAULT_SO_PERSONALTY = "Deredere"
    const val DEFAULT_SO_BLOOD = "B+"
    const val DEFAULT_SO_NICKNAME = "Kumiko-San"
    const val DEFAULT_USER_NICKNAME = "Master"
    const val DEFAULT_SCORE = 0
    //----

    //forbidden names
    val SPECIAL_CHARS_REG = "[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/\\?]".toRegex()
    val ONLY_NUMBERS_REG = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    const val NAME_1 = "gabrieltenmawhite"
    const val NAME_2 = "gabrielwhitetenma"
    const val NAME_3 = "gabrielwhite"
    const val NAME_4 = "gabrieltenma"
    const val NAME_5 = "whitetenma"
    const val NAME_6 = "tenmawhite"
    const val NAME_7 = "gabu"
    const val NAME_8 = "gabuchan"
    const val NAME_9 = "gabusan"
    const val NAME_10= "whitetenma"
    const val NAME_11 = "tenmawhite"
    const val NAME_12 = "gab"
    const val NAME_13 = "gabchan"
    const val NAME_14 = "gabsan"
    const val NAME_15 = "tenmakun"

    //validation
    const val INCOMPLETE = "incomplete"
    const val INVALID_CHARS = "invalid characters"
    const val SPECIAL_USER = "welcome back"
    const val FORBIDDEN_NAME = "DONT USE THAT NAME PLEASE"
    const val COMPLETE = "complete"

    //gab data
    const val GAB_USER_NAME = "Fran Tenma"
    const val MY_BDAY = "18/04/1996"
    const val MY_GENDER = "Male"
    const val GAB_BDAY = "20/04/1996"
    const val GAB_GENDER = "Female"
    const val GAB_SO_NAME = "Gabriel Tenma White"
    const val GAB_SO_HEIGHT = "144"
    const val GAB_SO_WEIGHT = "40"
    const val GAB_SO_BUST = "74"
    const val GAB_SO_WAIST = "58"
    const val GAB_SO_HIP = "80"
    const val GAB_SO_PERSONALTY = "Lazy Angel"
    const val GAB_SO_BLOOD = "?"
    const val GAB_SO_NICKNAME = "gab-chan"
    const val GAB_USER_NICKNAME = "fran-chan"
    const val GAB_SCORE = 1000000000
    //----

}