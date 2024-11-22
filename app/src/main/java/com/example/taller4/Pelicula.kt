package com.example.taller4

data class Pelicula(
    val titulo: String,
    val descripcion: String,
    val anio: Int,
    val calificacion: Double,
    val imagen: Int // Referencia a drawable
)
