package com.gmartinsdev.apitemplate

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *   Created by gmartins on 2024-05-20
 *   Description:
 */
fun main() {
    val url = "https://jsonplaceholder.typicode.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(Service::class.java)
    val response = service.fetchData()
    val result = response.execute()
    if (result.isSuccessful) {
        println(result.body())
    }
}