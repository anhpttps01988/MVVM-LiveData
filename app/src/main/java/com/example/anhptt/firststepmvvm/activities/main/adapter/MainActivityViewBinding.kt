package com.example.anhptt.firststepmvvm.activities.main.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.anhptt.firststepmvvm.data.source.response.Book
import org.jetbrains.annotations.NotNull

object MainActivityViewBinding {


    @BindingAdapter("app:dataList")
    @JvmStatic
    fun getBookDataList(recyclerView: RecyclerView, books: List<Book>?) {
        val adapter = recyclerView.adapter as BookAdapter
        if (books != null){
            adapter.replaceData(books)
        }else{
            adapter.replaceData(arrayListOf())
        }
    }

}