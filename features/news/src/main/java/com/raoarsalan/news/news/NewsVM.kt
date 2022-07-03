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

    init {
        getPopularNews()
    }

    fun getPopularNews() {
        startLoading()
        viewModelScope.launch {
            when (val res = newsInteractor.getPopularNews()) {
                is Result.Success -> {
                    endLoading()
                    newsInteractor.savePopularNews(res.data.results)
                    _observeNews.postValue(res.data.results)
                }

                is Result.GenericError -> {
                    endLoading(res.message)
                    _observeNews.postValue(newsInteractor.getPopularNewsLocally())
                }

                is Result.NetworkError -> {
                    endLoading("Network Error")
                    _observeNews.postValue(newsInteractor.getPopularNewsLocally())
                }
            }
        }
    }
}