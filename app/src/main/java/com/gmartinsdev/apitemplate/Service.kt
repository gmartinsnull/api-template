package com.gmartinsdev.apitemplate

import retrofit2.Call
import retrofit2.http.GET

/**
 *   Created by gmartins on 2024-05-20
 *   Description:
 */
interface Service {
    @GET("/users")
    fun fetchData(): Call<List<ApiData>>
}