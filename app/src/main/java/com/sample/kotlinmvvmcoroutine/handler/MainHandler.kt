package com.databinding.kotlinmvvm.handler

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.databinding.kotlinmvvm.adapter.UserListAdapter
import com.databinding.kotlinmvvm.view.MainActivity
import com.sample.kotlinmvvmcoroutine.STATE

class MainHandler(var mainActivity: AppCompatActivity) {
    fun getData() {
        (mainActivity as MainActivity).activityMainBinding.loading = true
        (mainActivity as MainActivity).viewmodel.getUsers().observe(mainActivity, Observer {
            if (it != null) {
                when (it.state) {
                    STATE.SUCCESS -> {
                        (mainActivity as MainActivity).activityMainBinding.loading = false
                        it.data?.let {
                            (mainActivity as MainActivity).activityMainBinding.recyclerVw.adapter =
                                UserListAdapter(mainActivity as Context, it)
                        }
                    }
                    STATE.LOADING -> {
                        (mainActivity as MainActivity).activityMainBinding.loading = true
                    }
                    STATE.ERROR -> {
                        (mainActivity as MainActivity).activityMainBinding.loading = false
                    }
                }
            }
        })

    }
}