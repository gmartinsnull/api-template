package com.gmartinsdev.apitemplate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *   Created by gmartins on 2024-05-20
 *   Description:
 */
class MainViewModel: ViewModel() {

    val state = MutableStateFlow<List<ApiData>>(emptyList())

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = "https://jsonplaceholder.typicode.com"
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(Service::class.java)
            val response = service.fetchData()
            val result = response.execute()
            if (result.isSuccessful)
                result.body()?.let {
                    state.value = it
                }
        }
    }
}