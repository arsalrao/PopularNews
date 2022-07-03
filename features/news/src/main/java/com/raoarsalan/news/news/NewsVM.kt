package com.raoarsalan.news.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.raoarsalan.base.BaseViewModel
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.interactor.NewsInteractor
import com.raoarsalan.core.domain.model.response.NewsModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsVM @Inject constructor(
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {


    val observeNews: MutableLiveData<List<NewsModel>> = MutableLiveData()

    init {
        getPopularNews()
    }

    fun getPopularNews() {
        startLoading()
        viewModelScope.launch {
            newsInteractor.getPopularNews()
                .collect {
                    when (it) {
                        is Result.Success -> {
                            endLoading()
                            newsInteractor.savePopularNews(it.data.results)
                            observeNews.postValue(it.data.results)
                        }

                        is Result.GenericError -> {
                            endLoading(it.message)
                            observeNews.postValue(newsInteractor.getPopularNewsLocally())
                        }

                        is Result.NetworkError -> {
                            endLoading("Network Error")
                            observeNews.postValue(newsInteractor.getPopularNewsLocally())
                        }
                    }
                }
        }
    }
}