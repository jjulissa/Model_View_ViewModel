package com.example.model_view_viewmodel.data.network

import com.example.model_view_viewmodel.core.RetrofitHelper
import com.example.model_view_viewmodel.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// crearemos una nueva clase llamada QuoteService, que será
// la clase a la que llame nuestro repositorio (cuando lo
// creemos) cuando queramos datos de internet y esta clase
// ya gestionaría la llamada a Retrofit
class QuoteService {
// Tenemos una instancia de nuestro RetrofitHelper.
    private val retrofit = RetrofitHelper.getRetrofit()

//  Tenemos una función que llamará a nuestra interfaz.
//  Dentro de la función getQuotes() estamos creando una
//  corrutina de tipo IO que serán las óptimas para hacer
//  llamadas de red o a bases de datos y esto retornará
//  lo que se haga dentro.
    suspend fun getQuotes() : List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }


    }
}