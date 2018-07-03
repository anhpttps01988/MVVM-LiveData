package com.example.anhptt.firststepmvvm.data.source.local.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [DataSample::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun daoService(): DaoService
}