package com.raoarsalan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T : ViewDataBinding, V : ViewModel>(private val modelClass: Class<V>) :
    Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.setBinding()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binding.executePendingBindings()
        listeners()
        observers()
    }

    abstract fun setBinding(): T
    protected open fun initViews() {}
    protected open fun observers() {}
    protected open fun listeners() {}


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}