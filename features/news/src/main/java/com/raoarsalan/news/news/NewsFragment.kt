package com.raoarsalan.news.news

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.raoarsalan.base.BaseFragment
import com.raoarsalan.base.utill.NavigationCommand
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.news.BR
import com.raoarsalan.news.adapter.NewsAdapter
import com.raoarsalan.news.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsVM>(NewsVM::class.java),
    NewsAdapter.OnItemClickListener {
    override val viewModelBindingVariable: Int
        get() = BR.viewModel

    override fun setBinding() = FragmentNewsBinding.inflate(layoutInflater)

    private val adapter = NewsAdapter(this)

    override fun initViews() {
        super.initViews()
        viewModel.getPopularNews()

        binding.rvNews.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onItemClick(item: NewsModel) {
        viewModel.navigationCommands.value = NavigationCommand.To(
            NewsFragmentDirections.actionNewsFragmentToDetailsNewsFragment()
        )
    }

    override fun observers() {
        super.observers()
        viewModel.observeNews.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}