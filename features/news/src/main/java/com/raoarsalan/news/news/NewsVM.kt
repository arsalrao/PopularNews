package com.raoarsalan.news.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.raoarsalan.base.BaseViewModel
import com.raoarsalan.base.utill.SingleLiveEvent
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.interactor.NewsInteractor
import com.raoarsalan.core.domain.model.response.NewsModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsVM @Inject constructor(
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

    private val _observeNews = SingleLiveEvent<List<NewsModel>>()
    val observeNews: LiveData<List<NewsModel>> = _observeNews

    fun getPopularNews() {
        viewModelScope.launch {
            when (val res = newsInteractor.getPopularNews()) {
                is Result.Success -> {
                    _observeNews.postValue(res.data.results)
                }

                is Result.GenericError -> {
                }

                is Result.NetworkError -> {
                }
            }
        }
    }
}