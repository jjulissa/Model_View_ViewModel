package com.example.model_view_viewmodel.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model_view_viewmodel.data.model.QuoteModel
import com.example.model_view_viewmodel.data.model.QuoteProvider
import com.example.model_view_viewmodel.domain.GetQuoteUseCase
import com.example.model_view_viewmodel.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

//  Para que nuestra clase sea un ViewModel, tenemos que
//  hacer que la clase creada extienda de dicha clase y es
//  por ello que ponemos : ViewModel() después del nombre de la clase.
class QuoteViewModel  : ViewModel() {

// implementando LiveData, que no es más que un tipo de
// datos al cual nuestra activity se puede conectar para
// saber cuando hay un cambio en dicho modelo.
//    Es decir,es live data para que la actividad se pueda
//    conectar, pero como el valor va a ser modificado es
//    mutable y ese modelo de datos encapsula el objeto
//    que queremos acceder, en este caso será un
//    QuoteModel porque iremos cambiando la cita cada vez
//    que el usuario toque la pantalla.
    val quoteModel= MutableLiveData<QuoteModel>()

//  La visibilidad del componente y para ello lo haremos
// desde el ViewModel. Crearemos un LiveData de tipo Boolean
//  y con él controlaremos el estado de nuestro loading.
    val isLoading = MutableLiveData<Boolean>()

    val getQuoteUseCase = GetQuoteUseCase()

    val getRandomQuoteUseCase = GetRandomQuoteUseCase()

//  Simplemente compruebo si el resultado no es vacío ni
//  null y pinto en la pantalla la primera posición
//  (ya que anteriormente no hacía nada hasta hacer el
//  primer clic en la pantalla).
    fun onCreate() {
//  Para poder lanzarlo desde aquí tendremos que usar ViewModelScope,
        viewModelScope.launch {

//  Controlaremos el estado para ponerlo visible antes de
//  la llamada al servidor y para ocultarlo al terminar.
            isLoading.postValue(true)

            val result = getRandomQuoteUseCase
//            val result = getQuoteUseCase

            if(result.) {
                quoteModel.postValue(result[0])
                isLoading.postValue((false))
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote: QuoteModel? = getRandomQuoteUseCase()

        if (quote!=null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }


}