package com.example.anhptt.firststepmvvm.activities.detail.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample


object DetailActivityViewBinding {
    @BindingAdapter("android:dataSampleList")
    @JvmStatic
    fun setDataSampleList(recyclerView: RecyclerView, list: List<DataSample>?) {
        val adapter = recyclerView.adapter as DetailAdapter
        if (list != null){
            adapter.replaceList(list)
        }else{
            adapter.replaceList(arrayListOf())
        }
    }
}