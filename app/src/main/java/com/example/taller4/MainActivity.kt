package com.example.taller4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.taller4.Fragments.DetallesPeliculaFragment
import com.example.taller4.Fragments.GestionPeliculasFragment
import com.example.taller4.Fragments.ListaPeliculasFragment
import com.example.taller4.Peliculas.Pelicula
import com.example.taller4.Peliculas.PeliculaRepository

class MainActivity : AppCompatActivity() {
    private var peliculaSeleccionada: Pelicula? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar los fragmentos al iniciar
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerLista, ListaPeliculasFragment())
            replace(R.id.fragmentContainerDetalles, DetallesPeliculaFragment())
            replace(R.id.fragmentContainerGestion, GestionPeliculasFragment())
        }
    }

    // Función para mostrar detalles de una película seleccionada
    fun mostrarDetallesPelicula(pelicula: Pelicula) {
        peliculaSeleccionada = pelicula
        val detallesFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerDetalles) as? DetallesPeliculaFragment
        detallesFragment?.mostrarDetalles(pelicula)
    }

    // Función para borrar la película seleccionada
    fun borrarPeliculaSeleccionada() {
        peliculaSeleccionada?.let { pelicula ->
            PeliculaRepository.borrarPelicula(pelicula)
            peliculaSeleccionada = null
            val listaFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerLista) as? ListaPeliculasFragment
            listaFragment?.actualizarLista()
        }
    }
}