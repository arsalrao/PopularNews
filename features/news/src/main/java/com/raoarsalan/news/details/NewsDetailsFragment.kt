package com.raoarsalan.news.details

import com.raoarsalan.base.BaseFragment
import com.raoarsalan.base.utill.NavigationCommand
import com.raoarsalan.news.BR
import com.raoarsalan.news.databinding.FragmentNewsDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment :
    BaseFragment<FragmentNewsDetailsBinding, NewsDetailsVM>(NewsDetailsVM::class.java) {
    override val viewModelBindingVariable: Int
        get() = BR.viewModel

    override fun setBinding() = FragmentNewsDetailsBinding.inflate(layoutInflater)

    override fun listeners() {
        super.listeners()
        binding.toolbar.setNavigationOnClickListener {
            viewModel.navigationCommands.value = NavigationCommand.Back
        }
    }
}