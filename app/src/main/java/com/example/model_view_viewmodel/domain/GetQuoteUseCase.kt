package com.example.model_view_viewmodel.domain

import com.example.model_view_viewmodel.data.QuoteRepository
import com.example.model_view_viewmodel.data.model.QuoteModel

class GetQuoteUseCase {
// llama al repositorio para decirle que recupere de internet todas las citas.
    private val repository = QuoteRepository()

//  Función es algo extraña ya que con el operator invoke
//  podemos llamar a esa función sin tener que darle un
//  nombre, es decir con hacer GetQuotesUseCase() ya se
//  estaría llamando, similar a un constructor pero sin
//  tener que pasarle los parámetros.
    suspend operator fun invoke(): List<QuoteModel>? =
         repository.getAllQuotes()

}

