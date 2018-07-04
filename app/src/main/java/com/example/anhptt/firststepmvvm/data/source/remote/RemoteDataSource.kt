package com.example.anhptt.firststepmvvm.data.source.remote

import com.example.anhptt.firststepmvvm.data.service.ServiceAPI
import com.example.anhptt.firststepmvvm.data.source.DataSource
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(retrofit: Retrofit) : DataSource {

    private var mServiceAPI: ServiceAPI = retrofit.create(ServiceAPI::class.java)

    override fun getBooks(): Observable<Response<List<Book>>> {
        return mServiceAPI.getBooks()
    }


    override fun getDataSample(): Flowable<List<DataSample>> {
        return Flowable.amb(null)
    }

    override fun insertDataSample(dataSample: DataSample) {
    }

    override fun updateDataSample(dataSample: DataSample) {
    }

    override fun deleteDataSample(dataSample: DataSample) {
    }
}