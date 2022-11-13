package com.databinding.kotlinmvvm.network

import androidx.lifecycle.MutableLiveData
import com.sample.kotlinmvvmcoroutine.Resource
import com.sample.kotlinmvvmcoroutine.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
   suspend fun getUser(): Response<ArrayList<User>>
}