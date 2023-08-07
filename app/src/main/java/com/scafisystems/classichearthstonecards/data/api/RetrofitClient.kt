package com.scafisystems.classichearthstonecards.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.scafisystems.classichearthstonecards.data.constants.ApiConstants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val client = OkHttpClient.Builder().apply {
    addInterceptor(CardInterceptor())
    readTimeout(60, TimeUnit.SECONDS)
}

val reqApi by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client.build())
        .build()
    return@lazy retrofit.create(CardService::class.java)
}
