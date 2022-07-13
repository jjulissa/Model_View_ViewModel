package com.example.model_view_viewmodel.data.model

class QuoteProvider {

    //  companion object ya que es la única forma de que
//  podamos acceder a esa información desde fuera de la clase.
    companion object {

        var quotes: List<QuoteModel> = emptyList()

    }
}