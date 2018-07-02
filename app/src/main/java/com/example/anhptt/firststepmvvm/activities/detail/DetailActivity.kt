package com.example.anhptt.firststepmvvm.activities.detail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.anhptt.firststepmvvm.R
import com.example.anhptt.firststepmvvm.ViewModelFactory
import com.example.anhptt.firststepmvvm.activities.detail.viewmodel.DetailActivityViewModel
import com.example.anhptt.firststepmvvm.common.activity.BaseActivity
import com.example.anhptt.firststepmvvm.databinding.ActivityDetailBinding
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailActivityViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this@DetailActivity, viewModelFactory).get(DetailActivityViewModel::class.java)
        lifecycle.addObserver(viewModel)
        binding.viewModel = viewModel
    }

}