package com.everday.customarouter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.everday.arouter_annotation.Route

@Route(path = "MainActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}