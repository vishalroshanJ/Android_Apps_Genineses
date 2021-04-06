package com.ltts.gensisesprogram

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fisrt.*
import kotlinx.android.synthetic.main.activity_main.buttonlogin

class Fisrt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fisrt)
        buttonlogin.setOnClickListener {
            if(editTextUsername.getText().toString().equals("vishal") && editTextPassword.getText().toString().equals("vishal") ){
                Toast.makeText(this, "Login Successfull ${editTextUsername.getText().toString()} ", Toast.LENGTH_SHORT).show()
                var myintern = Intent(this, Second::class.java)
                myintern.putExtra("key",editTextUsername.getText().toString())
                startActivity(myintern)
            }
            else{
                Toast.makeText(this, "Login UnSuccessfull ${editTextUsername.getText().toString()}", Toast.LENGTH_SHORT).show()
                var myintern = Intent(this, Fisrt::class.java)
                startActivity(myintern)
            }

    }
        buttoncancel.setOnClickListener {
            Toast.makeText( this,"Home Screen", Toast.LENGTH_SHORT).show()
            var myintern= Intent(this,MainActivity::class.java)
            startActivity(myintern)
        }
}}