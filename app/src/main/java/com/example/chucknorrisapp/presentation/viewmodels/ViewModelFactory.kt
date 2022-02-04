package com.example.chucknorrisapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.domain.Repository
import com.example.chucknorrisapp.domain.usecases.GetJokesUseCase
import com.example.chucknorrisapp.domain.usecases.ReturnJokesUseCase

class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    private val getJokesUseCase = GetJokesUseCase(repository)
    private val returnJokesUseCase = ReturnJokesUseCase(repository)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)){
            return MainFragmentViewModel(getJokesUseCase = getJokesUseCase,
                                        returnJokesUseCase = returnJokesUseCase) as T
        }
        throw IllegalAccessException("ViewModel class is not found")
    }
}