package com.example.taller4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaPeliculasFragment : androidx.fragment.app.Fragment() {

    private lateinit var peliculasAdapter: PeliculasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewPeliculas)
        peliculasAdapter = PeliculasAdapter(PeliculaRepository.obtenerPeliculas()) { pelicula ->
            (activity as MainActivity).mostrarDetallesPelicula(pelicula)
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = peliculasAdapter
        }

        return view
    }
}