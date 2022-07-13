package com.example.model_view_viewmodel.data

import com.example.model_view_viewmodel.data.model.QuoteModel
import com.example.model_view_viewmodel.data.model.QuoteProvider
import com.example.model_view_viewmodel.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    // añadir la instancia de nuestro service, si por ejemplo
// tuviéramos otro service para base de datos lo añadiríamos
// aquí y esta clase se encargaría de ir a base de datos o a internet.
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}