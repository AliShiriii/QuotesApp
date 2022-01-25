package com.example.quotesapp.api

import com.example.quotesapp.model.QuotesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    companion object{

        const val BASE_URL = "https://type.fit/"
    }

    @GET("api/quotes")
    fun callQuotes(): List<QuotesResponse>
}