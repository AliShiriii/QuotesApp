package com.example.quotesapp.api

interface QuotesApi {

    companion object{

        const val BASE_URL = "https://type.fit/"
    }

    fun getAll()
}