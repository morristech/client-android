package com.guru.cocktails.di.module

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.guru.cocktails.BuildConfig
import com.guru.cocktails.R
import com.guru.cocktails.data.source.remote.RequestInterceptor
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


@Module
class NetworkModule {

    @Provides
    @Named("baseUrl")
    @Singleton
    internal fun provideBaseUrl(context: Context): String {
        return context.getString(R.string.base_url)
    }

    @Provides
    @Named("productionOkhttpClient")
    @Singleton
    internal fun provideOkHttpClient(context: Context, cache: Cache): OkHttpClient {

        val client = OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor(context.getString(R.string.api_auth_user), context.getString(R.string.api_auth_key)))
        client.cache(cache)

        if (BuildConfig.DEBUG) {

            client.addNetworkInterceptor(StethoInterceptor())

            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logInterceptor)
        }

        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideRestAdapter(
        @Named("unsafeOkhttpClient") okHttpClient: OkHttpClient,
        @Named("baseUrl") baseUrl: String
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Named("unsafeOkhttpClient")
    @Singleton
    internal fun provideUnsafeOkhttpClient(context: Context, cache: Cache): OkHttpClient {

        /* Trust anything*/
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return emptyArray()
            }

            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
            }
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        val client = OkHttpClient.Builder()
        client.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        client.hostnameVerifier { _, _ -> true }
        client.cache(cache)

        /* Rest of config*/
        client.addInterceptor(RequestInterceptor(context.getString(R.string.api_auth_user), context.getString(R.string.api_auth_key)))
        client.addNetworkInterceptor(StethoInterceptor())

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.NONE
        client.addInterceptor(logInterceptor)

        if (!BuildConfig.DEBUG) {
            throw RuntimeException("You fool. Do not use this in production!!!")
        }

        return client.build()
    }


    @Provides
    @Singleton
    fun providePicasso(context: Context, @Named("unsafeOkhttpClient") okHttpClient: OkHttpClient): Picasso {
        val picasso = Picasso
            .Builder(context)
            .downloader(OkHttp3Downloader(okHttpClient))
            .build()

        Picasso.setSingletonInstance(picasso)

        if (BuildConfig.DEBUG) {
            picasso.setIndicatorsEnabled(true)
            picasso.isLoggingEnabled = true
        }

        return picasso
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        val cacheSize = 150L * 1024 * 1024  //150 MB
        return Cache(context.cacheDir, cacheSize)
    }
}
