package com.example.anhptt.firststepmvvm.data.source

import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Observable
import retrofit2.Response

interface DataSource {

    fun getBooks() : Observable<Response<List<Book>>>

}