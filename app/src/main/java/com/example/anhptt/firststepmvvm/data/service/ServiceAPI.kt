package com.example.anhptt.firststepmvvm.data.service

import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET


interface ServiceAPI {

    @GET("/api/items")
    fun getBooks(): Observable<Response<List<Book>>>

}