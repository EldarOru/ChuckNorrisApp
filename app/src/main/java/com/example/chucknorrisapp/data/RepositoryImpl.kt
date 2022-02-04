package com.example.chucknorrisapp.data

import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisapp.domain.Repository
import com.example.chucknorrisapp.domain.internet.RetrofitServices
import com.example.chucknorrisapp.domain.models.ChuckJokes
import retrofit2.Response

object RepositoryImpl: Repository {
    private val retrofitServices = RetrofitServices.getInstance()
    private val jokeLiveData = MutableLiveData<ChuckJokes>()

    override suspend fun getJokes(number: String): Response<ChuckJokes> = retrofitServices.getJokes(number)
    override fun returnJokes(): MutableLiveData<ChuckJokes> = jokeLiveData
}