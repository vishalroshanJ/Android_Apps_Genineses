package com.ltts.gensisesprogram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class                                                                                                                                                               Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
       var res=intent.extras!!.getString("key")
        textViewDisplay.setText(res)
    }
}