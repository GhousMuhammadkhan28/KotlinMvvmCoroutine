package com.databinding.kotlinmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.databinding.kotlinmvvm.network.ApiInterface
import com.sample.kotlinmvvmcoroutine.Resource
import com.sample.kotlinmvvmcoroutine.User
import kotlinx.coroutines.launch

class MyViewModel(var apiService:ApiInterface) : ViewModel() {
    fun getUsers(): MutableLiveData<Resource<ArrayList<User>>> {
        var listingContact = MutableLiveData<Resource<ArrayList<User>>>()
            viewModelScope.launch {
                try{
                    listingContact.postValue(Resource.loading(null))
                    listingContact.postValue(Resource.success(apiService.getUser().body()))
                }catch (e:Exception){
                    listingContact.postValue(Resource.error(null,"empty"))
                }

            }

        return listingContact
    }

}