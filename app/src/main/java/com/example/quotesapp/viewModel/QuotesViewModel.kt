package com.example.quotesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.model.QuotesResponse
import com.example.quotesapp.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private val quotesRepository: QuotesRepository) :
    ViewModel() {

    private val _quotes = MutableLiveData<Response<List<QuotesResponse>>>()
    val quotes: LiveData<Response<List<QuotesResponse>>>
        get() = _quotes

    init {

        callQuotes()

    }

    fun callQuotes() {

        viewModelScope.launch {
            val response = quotesRepository.callQuotes()

            _quotes.value = response
        }


    }
}