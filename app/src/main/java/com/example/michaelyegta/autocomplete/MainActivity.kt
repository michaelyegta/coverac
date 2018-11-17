package com.example.michaelyegta.autocomplete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)                        // apply Toolbar with customized centered title
        supportActionBar?.setDisplayShowTitleEnabled(false) // hide default Toolbar title
    }
}
