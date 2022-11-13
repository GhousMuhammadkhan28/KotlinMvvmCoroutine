package com.databinding.kotlinmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.databinding.kotlinmvvm.handler.MainHandler
import com.databinding.kotlinmvvm.network.MyClient
import com.databinding.kotlinmvvm.viewmodel.MyViewModel
import com.sample.kotlinmvvmcoroutine.Repo
import com.sample.kotlinmvvmcoroutine.R
import com.sample.kotlinmvvmcoroutine.databinding.ActivityMainBinding
import com.sample.kotlinmvvmcoroutine.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: MyViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.handler = MainHandler(this)
        viewmodel = ViewModelProvider(
            this,
            ViewModelFactory(
                Repo(MyClient.MyClientSingleton.getClient())
            )
        )[MyViewModel::class.java]
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        activityMainBinding.recyclerVw.layoutManager = linearLayoutManager
    }
}