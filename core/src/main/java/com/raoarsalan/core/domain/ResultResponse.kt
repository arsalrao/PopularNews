package com.raoarsalan.core.domain

data class ResultResponse<T>(var result: T?) {
    var cod: Int = 0
    var message: String = ""
        set(value) {
            field = value
            when {
                cod in 400..499 && result == null -> {
                    if (cod != 401 && cod != 403) {
                        if (message.isEmpty())
                            field = "Server Error"
                    } else {
                        field = "UnAuthorize"
                    }
                }
                else -> {
                    field = "Server Error"
                }
            }
        }

}