package com.guru.cocktails.data.source.remote

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor(apiAuthUser: String, apiAuthKey: String) : Interceptor {

    private val credentials: String = Credentials.basic(apiAuthUser, apiAuthKey)

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val requestBuilder = original.newBuilder().url(originalHttpUrl).addHeader("Authorization", credentials)
        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}