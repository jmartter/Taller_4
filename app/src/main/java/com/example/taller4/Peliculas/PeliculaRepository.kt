package com.example.taller4.Peliculas

import com.example.taller4.R

object PeliculaRepository {
    class PeliculaYaExisteException(message: String) : Exception(message)
    class ValoracionInvalidaException(message: String) : Exception(message)

    // Lista de películas de ejemplo
    private val peliculas = mutableListOf(
        Pelicula(
            titulo = "El Señor de los Anillos",
            descripcion = "Un épico viaje para destruir el Anillo Único.",
            anio = 2001,
            calificacion = 9.0,
            imagen = R.drawable.lord_of_the_rings
        ),
        Pelicula(
            titulo = "Inception",
            descripcion = "Un ladrón que roba secretos en los sueños.",
            anio = 2010,
            calificacion = 8.8,
            imagen = R.drawable.inception
        ),
        Pelicula(
            titulo = "Frozen",
            descripcion = "Dos hermanas y un viaje lleno de magia.",
            anio = 2013,
            calificacion = 7.5,
            imagen = R.drawable.frozen
        ),
        Pelicula(
            titulo = "Matrix",
            descripcion = "Un programador descubre la verdad detrás de su realidad.",
            anio = 1999,
            calificacion = 8.7,
            imagen = R.drawable.matrix
        ),
        Pelicula(
            titulo = "Toy Story",
            descripcion = "La vida secreta de los juguetes cuando los humanos no están presentes.",
            anio = 1995,
            calificacion = 8.3,
            imagen = R.drawable.toy_story
        )
    )

    fun obtenerPeliculas(): List<Pelicula> {
        return peliculas
    }

    fun borrarPelicula(pelicula: Pelicula) {
        peliculas.remove(pelicula)
    }

fun agregarPelicula(pelicula: Pelicula) {
    if (peliculas.any { it.titulo == pelicula.titulo }) {
        throw PeliculaYaExisteException("La película con el título '${pelicula.titulo}' ya existe.")
    }
    if (pelicula.calificacion !in 0.0..10.0) {
        throw ValoracionInvalidaException("La calificación debe estar entre 0 y 10.")
    }
    peliculas.add(pelicula)
}

    fun obtenerTitulosDePeliculas(): List<String> {
        return peliculas.map { it.titulo }
    }
}