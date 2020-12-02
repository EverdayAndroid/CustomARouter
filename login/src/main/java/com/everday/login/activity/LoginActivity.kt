package com.everday.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.everday.arouter_annotation.Route
import com.everday.login.R
@Route(path = "LoginActivity")
class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_login)
    }
}