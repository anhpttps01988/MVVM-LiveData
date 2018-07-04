package com.example.anhptt.firststepmvvm.activities.detail.adapter

import android.view.View
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample

interface ItemActionListener {
    fun onItemClick(dataSample: DataSample, view: View)
    fun onItemRemoveClick(dataSample: DataSample, view: View)
}