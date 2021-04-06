package com.ltts.gridviewandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    private var playerNames = arrayOf("Cristiano Ronaldo", "Joao Felix", "Bernado Silva", "Andre    Silve",
            "Fernandez", "William Carvalho", "Nelson Semedo", "Pepe", "Rui Patricio")
            private var playerImages = intArrayOf(R.drawable.player, R.drawable.player, R.drawable.player,
            R.drawable.player,R.drawable.player, R.drawable.player, R.drawable.player, R.drawable.player, R.drawable.player)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        gridView = findViewById(R.id.gridView)
        val mainAdapter = MainAdapter(this@MainActivity, playerNames, playerImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, "You CLicked " + playerNames[+position],
                    Toast.LENGTH_SHORT).show()
        }

    }
}