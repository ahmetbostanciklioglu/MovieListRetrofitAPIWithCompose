package com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.network

import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.model.Movie
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.utils.Constants.BASE_URL
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.utils.Constants.MOVIES_ENDPOINT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET(MOVIES_ENDPOINT)
    suspend fun getMovies(): List<Movie>

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}