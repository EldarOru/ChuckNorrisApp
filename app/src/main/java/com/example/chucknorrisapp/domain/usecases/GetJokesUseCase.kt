package com.example.chucknorrisapp.domain.usecases

import com.example.chucknorrisapp.domain.Repository
import com.example.chucknorrisapp.domain.models.ChuckJokes
import retrofit2.Response

class GetJokesUseCase(private val repository: Repository) {
    suspend fun getJokes(number: String): Response<ChuckJokes>{
        return repository.getJokes(number)
    }
}