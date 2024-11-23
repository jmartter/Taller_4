package com.example.taller4.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.taller4.R
import com.example.taller4.MainActivity

class GestionPeliculasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gestion_peliculas, container, false)

        val buttonDeleteMovie = view.findViewById<Button>(R.id.buttonDeleteMovie)
        buttonDeleteMovie.setOnClickListener {
            (activity as? MainActivity)?.borrarPeliculaSeleccionada()
        }

        return view
    }
}