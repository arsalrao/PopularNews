package com.raoarsalan.base

import androidx.lifecycle.ViewModel
import com.raoarsalan.core.domain.model.response.NewsModel

class ShareViewModel : ViewModel() {
    var news: NewsModel? = null
}