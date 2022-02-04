package com.example.chucknorrisapp.domain

import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisapp.domain.models.ChuckJokes
import retrofit2.Response

interface Repository {
    suspend fun getJokes(number: String): Response<ChuckJokes>
    fun returnJokes(): MutableLiveData<ChuckJokes>
}