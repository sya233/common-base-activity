package com.upai.commonbaseactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.upai.commonbaseactivity.main.MainModel
import com.upai.commonbaseactivity.main.MainPresenter
import com.upai.commonbaseactivity.main.MainView
import com.upai.commonbaseactivity.util.BaseActivity

class MainActivity : BaseActivity(), View.OnClickListener,MainView {

    private var mainPresenter:MainPresenter?=null

    private var toolbar:Toolbar?=null
    private var actionBar: ActionBar?=null

    private var btnMain:Button?=null

    override fun onCreate(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        // 控件id
        toolbar=findViewById(R.id.toolbar)
        btnMain=findViewById(R.id.btn_main)
        // 初始化Presenter
        mainPresenter= MainPresenter(this, MainModel())
        // 注册监听
        btnMain?.setOnClickListener(this)
    }

    override fun initData() {
        // 设置ActionBar
        setSupportActionBar(toolbar)
        actionBar=supportActionBar
        actionBar?.title="主界面"
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_main->mainPresenter?.btnMainClick()
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
