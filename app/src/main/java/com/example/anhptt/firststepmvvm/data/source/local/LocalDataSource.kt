package com.example.anhptt.firststepmvvm.data.source.local

import com.example.anhptt.firststepmvvm.data.source.DataSource
import com.example.anhptt.firststepmvvm.data.source.local.dao.DaoService
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(var dao: DaoService) : DataSource {

    override fun getBooks(): Observable<Response<List<Book>>> {
        return Observable.just(null)
    }

    override fun getDataSample(): Flowable<List<DataSample>> {
        return dao.loadDataAll()
    }

    override fun insertDataSample(dataSample: DataSample) {
        dao.insertData(dataSample)
    }

    override fun updateDataSample(dataSample: DataSample) {
        dao.update(dataSample)
    }
}