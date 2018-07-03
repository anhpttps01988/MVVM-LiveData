package com.example.anhptt.firststepmvvm.activities.detail.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.example.anhptt.firststepmvvm.R
import com.example.anhptt.firststepmvvm.activities.detail.adapter.DetailAdapter
import com.example.anhptt.firststepmvvm.common.viewmodel.ViewModelFactory
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
        setupToolbar()
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this@DetailActivity, viewModelFactory).get(DetailActivityViewModel::class.java)
        lifecycle.addObserver(viewModel)
        binding.contentDetail!!.viewModel = viewModel
        val adapter = DetailAdapter(arrayListOf())
        binding.contentDetail!!.recyclerList.layoutManager = LinearLayoutManager(this@DetailActivity, 1, false)
        binding.contentDetail!!.recyclerList.addItemDecoration(DividerItemDecoration(this@DetailActivity, 1))
        binding.contentDetail!!.recyclerList.adapter = adapter
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}