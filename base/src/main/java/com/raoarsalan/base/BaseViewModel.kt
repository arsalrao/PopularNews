package com.raoarsalan.base

import androidx.lifecycle.ViewModel
import com.raoarsalan.base.utill.NavigationCommand
import com.raoarsalan.base.utill.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    lateinit var shareViewModel: ShareViewModel
}