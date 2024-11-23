package com.example.taller4.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import com.example.taller4.Peliculas.Pelicula
import com.example.taller4.R

class DetallesPeliculaFragment : Fragment() {

    private var pelicula: Pelicula? = null

    fun mostrarDetalles(pelicula: Pelicula) {
        this.pelicula = pelicula
        view?.let { actualizarUI(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalles_pelicula, container, false)
        actualizarUI(view)
        return view
    }

    private fun actualizarUI(view: View) {
        pelicula?.let {
            view.findViewById<TextView>(R.id.textTitulo).text = it.titulo
            view.findViewById<TextView>(R.id.textDescripcion).text = it.descripcion
            view.findViewById<TextView>(R.id.textAnio).text = "Año: ${it.anio}"
            view.findViewById<TextView>(R.id.textCalificacion).text = "Calificación: ${it.calificacion}"
            view.findViewById<ImageView>(R.id.imagePelicula).setImageResource(it.imagen)
        }
    }
}