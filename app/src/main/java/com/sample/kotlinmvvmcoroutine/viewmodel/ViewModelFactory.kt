package com.sample.kotlinmvvmcoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.databinding.kotlinmvvm.network.ApiInterface
import com.databinding.kotlinmvvm.viewmodel.MyViewModel

class ViewModelFactory(var apiService:ApiInterface):ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}