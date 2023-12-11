package com.example.chitter.network
import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private fun provideOkHttpClient(context: Context): OkHttpClient {
    //val apiKey = context.getString(R.string.api_key)
    val apiKey = "7ffe56dc-472d-4a5a-af34-ce207770fd6b"

    return OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .header("API-Key", apiKey)
                .build()
            chain.proceed(newRequest)
        })
        .build()
}

private fun provideRetrofit(context: Context): Retrofit {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    return Retrofit.Builder()
        .client(provideOkHttpClient(context))
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
}

object BirdApi {
    private lateinit var retrofitService: BirdApiService

    fun initialize(context: Context) {
        val retrofit = provideRetrofit(context)
        retrofitService = retrofit.create(BirdApiService::class.java)
    }

    val service: BirdApiService
        get() = retrofitService
}

private const val BASE_URL = "https://nuthatch.lastelm.software/v2/"