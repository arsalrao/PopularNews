package com.raoarsalan.base.utill

import android.app.Dialog
import android.content.Context
import com.raoarsalan.core.R

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.loading_layout)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCanceledOnTouchOutside(false)
        show()
    }
}