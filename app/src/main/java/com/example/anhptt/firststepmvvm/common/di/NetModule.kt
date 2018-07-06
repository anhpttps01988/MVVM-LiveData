package com.example.anhptt.firststepmvvm.common.di

import android.app.Application
import android.content.Context
import com.example.anhptt.firststepmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import com.google.gson.GsonBuilder
import com.google.gson.Gson




@Module
open class NetModule{

    @Singleton
    @Provides
    fun okhttpClient(application: Application): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                    val newBuilder = request!!.newBuilder()!!.addHeader("User-Agent", "Android")
                    chain.proceed(newBuilder!!.build())
                }
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val builder = Retrofit.Builder()
        builder.baseUrl(Constants.URL)
        return builder.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }
}