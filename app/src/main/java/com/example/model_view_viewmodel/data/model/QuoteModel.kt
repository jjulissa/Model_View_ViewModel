package com.example.model_view_viewmodel.data.model

import com.google.gson.annotations.SerializedName

//  Según la arquitectura MVVM la parte del modelo será
//  la encargada de acceder a la base de datos o al servicio
//  web que nos devuelva la información, Para simplificar
//  este primer capítulo de muchos, tendremos nuestro propio
//  proveedor de citas, es decir, una clase con varias citas
//  con un método que aleatoriamente devolverá una u otra.
data class QuoteModel (@SerializedName("quote") val quote: String, @SerializedName("author") val author: String)
