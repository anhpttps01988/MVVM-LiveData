package com.example.anhptt.firststepmvvm.data.source.local.dao.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.anhptt.firststepmvvm.App
import com.example.anhptt.firststepmvvm.data.source.local.dao.RoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class RoomModule {

    @Singleton
    @Provides
    fun room(app: Application): RoomDatabase = Room.databaseBuilder(app.applicationContext, RoomDatabase::class.java, "database.db")
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun daoService(roomDb: RoomDatabase) = roomDb.daoService()

}