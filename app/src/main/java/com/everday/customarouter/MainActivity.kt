package com.everday.customarouter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ever_day.apt.HelloAPT
import com.everday.arouter_annotation.Route

@Route(path = "MainActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val aptName = HelloAPT.getName("apt生成的方法")
        findViewById<TextView>(R.id.tv).text = aptName
    }
}