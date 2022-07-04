package com.example.retrofithowtodoandroid

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("volley_array.json")
    fun getMovies(): Call<List<Movie>>

    companion object {
        var baseUrl = "http://velmm.com/apis/"

        fun createInstance(): ApiInterface {
            val retrofit =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                    baseUrl
                ).build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}