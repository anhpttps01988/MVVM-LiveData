package com.example.anhptt.firststepmvvm.data.source

import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response

interface DataSource {

    fun getBooks(): Observable<Response<List<Book>>>

    fun getDataSample(): Flowable<List<DataSample>>

    fun insertDataSample(dataSample: DataSample)

    fun updateDataSample(dataSample: DataSample)

    fun deleteDataSample(dataSample: DataSample)
}