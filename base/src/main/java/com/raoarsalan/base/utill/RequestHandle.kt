package com.raoarsalan.base.utill

/**
 * utility class to handle request loader and show error msg
 */
data class RequestHandle(
    var showLoading: Boolean,
    var isSuccess: Boolean,
    var message: String
)