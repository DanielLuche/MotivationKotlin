package com.dluche.motivation.util

//private constructor significa que a classe não precisa ser instanciada por outra classe
//Ela será, na verdade, uma classe static, igual no java.
class MotivationContants private constructor(){
    //
    object KEY {
         val PERSON_NAME = "personName"
    }

    object PHRASE_FILTER{
        val ALL = 1
        val SUN = 2
        val HAPPY = 3
    }
}