package com.example.taller4

object PeliculaRepository {

    // Lista de películas de ejemplo
    private val peliculas = listOf(
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
        )
    )

    // Método para obtener todas las películas
    fun obtenerPeliculas(): List<Pelicula> {
        return peliculas
    }

    // Método para obtener una película por su título (opcional)
    fun obtenerPeliculaPorTitulo(titulo: String): Pelicula? {
        return peliculas.find { it.titulo == titulo }
    }
}