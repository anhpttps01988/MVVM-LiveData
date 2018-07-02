package com.example.anhptt.firststepmvvm.data.source

import com.example.anhptt.firststepmvvm.common.di.scopes.Local
import com.example.anhptt.firststepmvvm.common.di.scopes.Remote
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(@Local private var localDataSource: DataSource, @Remote private var remoteDataSource: DataSource) : DataSource {

    override fun getBooks(): Observable<Response<List<Book>>> {
        return remoteDataSource.getBooks().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    }

}