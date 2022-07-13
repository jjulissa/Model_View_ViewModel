package com.example.model_view_viewmodel.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.model_view_viewmodel.databinding.ActivityMainBinding
import com.example.model_view_viewmodel.ui.viewModel.QuoteViewModel

//  Model(XML,Activity, Fragment): Parte de datos, cuando recuperamos
//  de una base de datos o de un servicio web,
//  toda esa información la almacenaremos
//  en modelos de datos.

//View: parte de la UI, los XML, las activities y los fragments.
// Ejemplo al pulsar un botón pero no realizarán
// las acciones, se suscribirán al view model
// y este les dirá cuando y como pintar.

// ViewModel(Room,Retrofit): Conexión entre el modelo y la vista.
// Las vistas se suscriben a sus respectivos
// viewModels y estos al percatarse de que el modelo
// ha sido modificado lo notificarán a la vista.

// LIVE DATA: SistemaQueNosPermiteSouscribirnosA,
// LosCambiosDeNuestrosProyectos..
class MainActivity : AppCompatActivity() {

//  La idea es unir dicha actividad a nuestro ViewModel para
//  poder estar suscrito a los cambios y modificar la UI
//  cuando sea necesario.

    private lateinit var binding : ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//  setContentView(R.layout.activity_main)

//  llamamos a esta función desde su onCreate()
//  quoteViewModel, SeYonKlasKiNanPackageViewModelLa.
        quoteViewModel.onCreate()

//  llamar a nuestro ViewModel y dentro de este accedemos
//  a nuestro objeto con live data para llamar a la función
//  observe(). Dentro le pasaremos el owner que es this
//  y aquí lleva una función Observer{}, fíjate que al
//  valor que retorna lo he llamado currentQuote, para
//  ello solo tengo que ponerlo al principio y añadir ->
//  pero podríamos borrar eso y acceder con un it.
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

//  Cambios para poder cambiar la visibilidad.
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
//            progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
//  Con lo que tenemos programado ya se pintarán los cambios
//  de la UI automáticamente cada vez que nuestro objeto
//  con live data sea modificado pero nunca lo estamos
//  modificando ya que se cambia al llamar a la función
//  randomQuote() del ViewModel. Para ello vamos a terminar
//  añadiendo un setOnClickListener al constraintLayout principal.
            quoteViewModel.randomQuote()
        }
    }
}