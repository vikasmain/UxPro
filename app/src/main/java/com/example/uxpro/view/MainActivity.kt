package com.example.uxpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uxpro.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }
}
