package com.dluche.motivation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dluche.motivation.util.MotivationContants
import com.dluche.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener{


    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //
        mSecurity = SecurityPreferences(this)
        //
        splash_btn_save.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id  = v.id
        if(id == R.id.splash_btn_save){
            handleSave()
        }

    }

    private fun handleSave() {
        val name: String = splash_et_name.text.toString()
        //
        mSecurity.storeString(MotivationContants.KEY.PERSON_NAME,name)
    }
}
