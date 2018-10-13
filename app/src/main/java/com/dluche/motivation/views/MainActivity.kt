package com.dluche.motivation.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dluche.motivation.R
import com.dluche.motivation.mock.Mock
import com.dluche.motivation.util.MotivationContants
import com.dluche.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = MotivationContants.PHRASE_FILTER.ALL
    private lateinit var mSecurityPreferences : SecurityPreferences
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        mSecurityPreferences = SecurityPreferences(this)
        //
        setListners()
        //
        handleFilter(R.id.main_iv_all)
        refreshPhrase()
        //
        verifyUserName()
    }

    private fun verifyUserName() {
        main_tv_user_name.text = mSecurityPreferences.getStoredString(MotivationContants.KEY.PERSON_NAME)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listId = listOf(R.id.main_iv_all,R.id.main_iv_sun,R.id.main_iv_happy)
        if(id in listId){
            handleFilter(id)
        }else if(id == R.id.main_btn_new_phrase){
            refreshPhrase()
        }
    }

    private fun setListners() {
        main_iv_all.setOnClickListener(this)
        main_iv_sun.setOnClickListener(this)
        main_iv_happy.setOnClickListener(this)
        main_btn_new_phrase.setOnClickListener(this)
    }

    private fun handleFilter(id: Int) {
        main_iv_all.setImageResource(R.drawable.ic_all_unselected)
        main_iv_sun.setImageResource(R.drawable.ic_sun_unselected)
        main_iv_happy.setImageResource(R.drawable.ic_happy_unselected)

        if(id == R.id.main_iv_all){
            mFilter = MotivationContants.PHRASE_FILTER.ALL
            main_iv_all.setImageResource(R.drawable.ic_all_selected)
        }else if(id == R.id.main_iv_sun){
            mFilter = MotivationContants.PHRASE_FILTER.SUN
            main_iv_sun.setImageResource(R.drawable.ic_sun_selected)
        }else{
            mFilter = MotivationContants.PHRASE_FILTER.HAPPY
            main_iv_happy.setImageResource(R.drawable.ic_happy_selected)
        }
    }

    private fun refreshPhrase() {
        main_tv_phrase.text = mMock.getPhrase(mFilter)
    }


}
