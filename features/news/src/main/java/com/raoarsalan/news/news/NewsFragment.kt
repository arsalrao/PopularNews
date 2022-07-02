package com.raoarsalan.news.news

import com.raoarsalan.base.BaseFragment
import com.raoarsalan.news.BR
import com.raoarsalan.news.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsVM>(NewsVM::class.java) {
    override val viewModelBindingVariable: Int
        get() = BR.viewModel

    override fun setBinding() = FragmentNewsBinding.inflate(layoutInflater)
}