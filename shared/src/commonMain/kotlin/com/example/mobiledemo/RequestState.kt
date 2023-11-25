package com.example.mobiledemo

import kotlinx.serialization.Serializable

@Serializable
sealed class RequestState {
    @Serializable
    data object Idle: RequestState()
    @Serializable
    data object Loading: RequestState()
    @Serializable
    data class Success(val data: Products): RequestState()
    @Serializable
    data class Error(val message: String): RequestState()

    fun isLoading(): Boolean = this is Loading
    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error

    fun getProducts(): Products = Products(
        items = (this as Success).data.items
    )

    fun gerErrorMessage(): String = (this as Error).message
}