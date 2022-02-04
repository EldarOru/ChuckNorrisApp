package com.example.chucknorrisapp.domain.internet

import com.example.chucknorrisapp.domain.models.ChuckJokes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServices {
    @GET("jokes/random/{number}")
    suspend fun getJokes(@Path ("number") number: String): Response<ChuckJokes>

    companion object{
        var retrofitService: RetrofitServices? = null
        fun getInstance() : RetrofitServices {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServices::class.java)
            }
            return retrofitService!!
        }

        const val BASE_URL = "http://api.icndb.com/"
    }
}