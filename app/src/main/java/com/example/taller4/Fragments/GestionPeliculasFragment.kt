package com.example.taller4.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.taller4.R
import com.example.taller4.MainActivity
import com.example.taller4.Peliculas.Pelicula
import com.example.taller4.Peliculas.PeliculaRepository

class GestionPeliculasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gestion_peliculas, container, false)

        val buttonAddMovie = view.findViewById<Button>(R.id.buttonAddMovie)
        buttonAddMovie.setOnClickListener {
            mostrarDialogoAgregarPelicula()
        }

        val buttonDeleteMovie = view.findViewById<Button>(R.id.buttonDeleteMovie)
        buttonDeleteMovie.setOnClickListener {
            (activity as? MainActivity)?.borrarPeliculaSeleccionada()
        }

        return view
    }

    private fun mostrarDialogoAgregarPelicula() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_movie, null)
        val editTextTitle = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = dialogView.findViewById<EditText>(R.id.editTextDescription)
        val editTextYear = dialogView.findViewById<EditText>(R.id.editTextYear)
        val editTextRating = dialogView.findViewById<EditText>(R.id.editTextRating)

        AlertDialog.Builder(context)
            .setTitle("Add Movie")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = editTextTitle.text.toString()
                val description = editTextDescription.text.toString()
                val year = editTextYear.text.toString().toIntOrNull() ?: 0
                val rating = editTextRating.text.toString().toDoubleOrNull() ?: 0.0
                val movie = Pelicula(title, description, year, rating, R.drawable.default_image)
                PeliculaRepository.agregarPelicula(movie)
                (activity as? MainActivity)?.actualizarListaPeliculas()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}