package com.example.chucknorrisapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorrisapp.domain.usecases.GetJokesUseCase
import com.example.chucknorrisapp.domain.usecases.ReturnJokesUseCase
import kotlinx.coroutines.*

class MainFragmentViewModel(private val getJokesUseCase: GetJokesUseCase,
                            private val returnJokesUseCase: ReturnJokesUseCase): ViewModel(){
    val onSuccess = MutableLiveData<Unit>()
    val errorMessage = MutableLiveData<String>()
    val jokesLiveData = returnJokesUseCase.returnJokes()
    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        ("Exception handled: ${throwable.localizedMessage}")
    }

    fun getJokes(number: String){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = getJokesUseCase.getJokes(number)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    jokesLiveData.postValue(response.body())
                    onSuccess.value = Unit
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}