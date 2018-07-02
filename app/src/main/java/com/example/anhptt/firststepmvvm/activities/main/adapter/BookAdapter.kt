package com.example.anhptt.firststepmvvm.activities.main.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anhptt.firststepmvvm.R
import com.example.anhptt.firststepmvvm.data.source.response.Book
import com.example.anhptt.firststepmvvm.databinding.BookItemBinding

class BookAdapter(books: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private var mBooks: List<Book>? = null

    init {
        setList(books)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    fun replaceData(list: List<Book>) {
        setList(list)
    }

    override fun getItemCount(): Int {
        return mBooks!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = mBooks!![position]
        holder.bind(book)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: BookItemBinding = DataBindingUtil.bind(itemView)!!
        fun bind(book: Book) {
            binding.book = book
            binding.executePendingBindings()
        }
    }

    private fun setList(list: List<Book>) {
        this.mBooks = list
        notifyDataSetChanged()
    }
}