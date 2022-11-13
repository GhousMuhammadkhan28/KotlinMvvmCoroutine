package com.sample.kotlinmvvmcoroutine

import com.databinding.kotlinmvvm.network.ApiInterface
import retrofit2.Response

class Repo(var apiInterface: ApiInterface) : ApiInterface {
    override suspend fun getUser(): Response<ArrayList<User>> = apiInterface.getUser()
}