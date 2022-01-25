package com.example.quotesapp.repository

import com.example.quotesapp.api.QuotesApi
import com.example.quotesapp.model.QuotesResponse
import retrofit2.Response
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val quotesApi: QuotesApi) {

    fun callQuotes(): Response<List<QuotesResponse>> {

        return quotesApi.callQuotes()
    }
}