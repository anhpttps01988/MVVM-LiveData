package com.example.anhptt.firststepmvvm.data.source.di

import com.example.anhptt.firststepmvvm.common.di.scopes.Local
import com.example.anhptt.firststepmvvm.common.di.scopes.Remote
import com.example.anhptt.firststepmvvm.data.source.DataSource
import com.example.anhptt.firststepmvvm.data.source.local.LocalDataSource
import com.example.anhptt.firststepmvvm.data.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Local
    @Binds
    @Singleton
    abstract fun localDataSource(dataSource: LocalDataSource): DataSource

    @Remote
    @Binds
    @Singleton
    abstract fun remoteDataSource(dataSource: RemoteDataSource): DataSource
}