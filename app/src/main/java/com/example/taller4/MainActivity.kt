package com.example.taller4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de tener el layout "activity_main.xml"

        // Cargar los fragmentos al iniciar
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerLista, ListaPeliculasFragment())
            replace(R.id.fragmentContainerDetalles, DetallesPeliculaFragment())
        }
    }

    // Función para mostrar detalles de una película seleccionada
    fun mostrarDetallesPelicula(pelicula: Pelicula) {
        val detallesFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerDetalles) as? DetallesPeliculaFragment
        detallesFragment?.mostrarDetalles(pelicula)
    }
}