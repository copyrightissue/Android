/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// TOD: Create a property for the base URL provided in the codelab

// TOD: Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON

// TOD: Build a Retrofit object with the Moshi converter
//Base URL: https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/
//GET amphibians list: android-basics-kotlin-unit-4-pathway-2-project-api.json
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private const val BASE_URL = "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AmphibianApiService {
    // TOD: Declare a suspended function to get the list of amphibians
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibians(): List<Amphibian>
}

// TOD: Create an object that provides a lazy-initialized retrofit service
//Create an AmphibianApi object to expose a lazy-initialized Retrofit service that uses the AmphibianApiService interface.
object AmphibianApi {
    val service : AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}

