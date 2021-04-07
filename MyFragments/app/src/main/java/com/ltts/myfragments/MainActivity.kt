package com.ltts.myfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonred.setOnClickListener {
            var frag1= RedFragment()
            var manage=supportFragmentManager
            var transact=manage.beginTransaction()
            transact.replace(R.id.fragment,frag1)
            transact.commit()
        }
        buttonblue.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment,BlueFragmennt()).commit()
        }
        buttongreen.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment,GreenFragement()).commit()
        }
    }

    }
