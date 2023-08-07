package com.scafisystems.classichearthstonecards.data.api

import com.scafisystems.classichearthstonecards.data.constants.ApiConstants.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class CardInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key", API_KEY)
            .build()

        return chain.proceed(request)
    }
}