package com.dluche.motivation.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    //Primeiro oparametro nome do arquivo de preferencias
    //Segunda parametro, modo de acesso ao arquivo. Private significa que somente nosso app terá acesso.
    //É possivel compartilhar arquivos de preferencias entre app, mas , para isso, devemos usar
    //outros modos.
    private val mSharedPreferences:SharedPreferences =
            context.getSharedPreferences("motivation",Context.MODE_PRIVATE)
    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key,value).apply()
    }
    fun getString(key: String): String{
        return mSharedPreferences.getString(key,"")
    }

}