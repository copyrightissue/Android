package com.example.chitter.network


import retrofit2.http.GET
import retrofit2.http.Query

interface BirdApiService {
    @GET("birds")
    suspend fun getBirds(@Query("page") page: Int,
                         @Query("pageSize") pageSize: Int,
                         @Query("hasImg") hasImg: Boolean,
                         @Query("operator") operator: String): List<Bird>
}