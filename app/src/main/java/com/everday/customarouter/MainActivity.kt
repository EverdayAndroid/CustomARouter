package com.everday.customarouter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.everday.arouter_annotation.Route
import com.everday.login.activity.LoginActivity
@Route(path = "MainActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG","${BuildConfig.DEBUG}")
    }
    fun login(v:View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}