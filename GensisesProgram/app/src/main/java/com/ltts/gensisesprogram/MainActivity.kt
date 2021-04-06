package com.ltts.gensisesprogram

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonlogin.setOnClickListener {
            Toast.makeText( this,"Login Successfull", Toast.LENGTH_SHORT).show()
            var myintern=Intent(this,Fisrt::class.java)
            startActivity(myintern)

        }
    }

}