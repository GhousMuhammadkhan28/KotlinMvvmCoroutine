package com.sample.kotlinmvvmcoroutine

class Resource<out T>(val state: STATE, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(STATE.SUCCESS, data, null)
        fun <T> loading(data: T?): Resource<T> = Resource(STATE.LOADING, data, null)
        fun <T> error(data: T?, message: String?): Resource<T> = Resource(STATE.ERROR, data, message)
    }
}