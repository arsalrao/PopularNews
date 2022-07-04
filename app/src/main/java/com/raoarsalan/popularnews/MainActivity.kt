package com.raoarsalan.popularnews

import com.raoarsalan.base.BaseActivity
import com.raoarsalan.popularnews.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    override fun setBinding() = ActivityMainBinding.inflate(layoutInflater)

}