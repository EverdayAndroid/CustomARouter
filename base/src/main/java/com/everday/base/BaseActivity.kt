package com.everday.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
/**
 * @author wt
 * @date 21:40 2020/11/22
 * @description
 **/
open abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResID())
    }
    //视图
    abstract fun getLayoutResID():Int

}