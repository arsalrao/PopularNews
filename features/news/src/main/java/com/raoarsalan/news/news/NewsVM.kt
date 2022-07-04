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
        setNoData(false)
        viewModelScope.launch {
            newsInteractor.getPopularNews()
                .collect {
                    when (it) {
                        is Result.Success -> {
                            val list = it.data.results
                            endLoading()
                            setNoData(list.isEmpty())
                            newsInteractor.savePopularNews(list)
                            observeNews.postValue(list)
                        }

                        is Result.GenericError -> {
                            setNoData(false)
                            endLoading(it.message)
                            observeNews.postValue(newsInteractor.getPopularNewsLocally())
                        }

                        is Result.NetworkError -> {
                            setNoData(false)
                            endLoading("Network Error")
                            observeNews.postValue(newsInteractor.getPopularNewsLocally())
                        }
                    }
                }
        }
    }
}