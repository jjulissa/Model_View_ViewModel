package com.example.model_view_viewmodel.domain

import com.example.model_view_viewmodel.data.QuoteRepository
import com.example.model_view_viewmodel.data.model.QuoteModel
import com.example.model_view_viewmodel.data.model.QuoteProvider

class GetRandomQuoteUseCase {

//  Lo primero que estamos haciendo es acceder directamente
//  a la memoria en vez de pasar por nuestro repositorio,
//  pero como es una corrutina no quiero complicar más esta segunda parte.
    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes

//  Comprobamos si no es null ni vacío y entonces generamos
//  un número random entre cero (la primera posición del
//  listado) y la última posición del listado para que
//  devuelva una cita aleatoria o sino hay devolverá un null.
        if (!quotes.isNullOrEmpty()) {
            val randomNumber:Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}