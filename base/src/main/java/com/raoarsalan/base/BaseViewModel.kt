package com.raoarsalan.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.raoarsalan.base.utill.NavigationCommand
import com.raoarsalan.base.utill.RequestHandle
import com.raoarsalan.base.utill.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    lateinit var shareViewModel: ShareViewModel

    private val _observeLoading = SingleLiveEvent<RequestHandle>()
    val observeLoading: LiveData<RequestHandle> = _observeLoading

    fun startLoading() {
        _observeLoading.postValue(
            RequestHandle(
                showLoading = true,
                isSuccess = false,
                message = ""
            )
        )
    }


    fun endLoading(errorMessage: String? = null) {
        _observeLoading.postValue(
            RequestHandle(
                showLoading = false,
                isSuccess = false,
                message = errorMessage ?: ""
            )
        )
    }
}