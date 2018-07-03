package com.example.anhptt.firststepmvvm.common.bindingadapter

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import com.example.anhptt.firststepmvvm.activities.detail.viewmodel.DetailActivityViewModel
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.firststepmvvm.common.viewmodel.BaseViewModel


object SwipeRefreshDataBinding {


    @BindingAdapter("android:onRefresh")
    @JvmStatic
    fun setRefreshLayoutDataOnLayoutListener(view: SwipeRefreshLayout, viewModel: BaseViewModel) {
        view.setOnRefreshListener {
            if (viewModel is MainActivityViewModel) {
                viewModel.refreshBookData(true)
            } else if (viewModel is DetailActivityViewModel) {
                viewModel.onRefreshData(true)
            }
        }
    }

}