package com.upai.commonbaseactivity.util

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val TAG: String = "BaseActivity"
    protected var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        ActivityUtil.getInstance().addActivity(this)
        Log.d(TAG, localClassName)
        setContentView(onCreate())

        initView()
        initData()
    }

    protected abstract fun onCreate(): Int

    protected abstract fun initView()

    protected abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        ActivityUtil.getInstance().removeActivity(this)
    }

}