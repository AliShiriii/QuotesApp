package com.example.quotesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.model.QuotesResponse
import com.example.quotesapp.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private val quotesRepository: QuotesRepository) :
    ViewModel() {

    private val _quotes = MutableLiveData<List<QuotesResponse>>()
    val quotes: LiveData<List<QuotesResponse>>
        get() = _quotes

    fun callQuotes() {

        viewModelScope.launch {
            val response = quotesRepository.callQuotes()

            _quotes.postValue(response)

        }

    }
}