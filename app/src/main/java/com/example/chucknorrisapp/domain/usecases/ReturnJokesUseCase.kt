package com.example.chucknorrisapp.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisapp.domain.Repository
import com.example.chucknorrisapp.domain.models.ChuckJokes

class ReturnJokesUseCase(private val repository: Repository) {
    fun returnJokes(): MutableLiveData<ChuckJokes>{
        return repository.returnJokes()
    }
}