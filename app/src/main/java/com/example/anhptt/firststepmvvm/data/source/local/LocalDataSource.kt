package com.example.anhptt.firststepmvvm.data.source.local

import com.example.anhptt.firststepmvvm.data.source.DataSource
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor() : DataSource {

    override fun getBooks(): Observable<Response<List<Book>>> {
        return Observable.just(null)
    }

}