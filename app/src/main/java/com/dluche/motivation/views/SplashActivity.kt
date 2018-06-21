package com.dluche.motivation.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.dluche.motivation.R
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
        if(name.trim().isEmpty()){
            Toast.makeText(this,getString(R.string.digite_o_nome),Toast.LENGTH_LONG).show()
        }else {
            //
            mSecurity.storeString(MotivationContants.KEY.PERSON_NAME, name)
            //
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            //
            //finish()
        }
    }
}
