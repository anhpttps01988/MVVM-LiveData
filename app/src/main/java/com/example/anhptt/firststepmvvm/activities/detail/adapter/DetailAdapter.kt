package com.example.anhptt.firststepmvvm.activities.detail.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anhptt.firststepmvvm.R
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample
import com.example.anhptt.firststepmvvm.databinding.ItemDataSampleBinding


class DetailAdapter(listData: List<DataSample>) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    private var mListData: List<DataSample>? = null

    init {
        setList(listData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_data_sample, parent, false)
        return ViewHolder(View)
    }


    override fun getItemCount(): Int {
        return mListData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mListData!![position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemDataSampleBinding = DataBindingUtil.bind(itemView)!!
        fun bind(dataSample: DataSample) {
            binding.data = dataSample
            binding.executePendingBindings()
        }
    }

    fun replaceList(list: List<DataSample>){
        setList(list)
    }

    private fun setList(list: List<DataSample>) {
        this.mListData = list
        notifyDataSetChanged()
    }
}