package com.example.taller4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculasAdapter(
    private val peliculas: List<Pelicula>,
    private val onItemClick: (Pelicula) -> Unit
) : RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder>() {

    inner class PeliculaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.textTitulo)
        val imagen: ImageView = itemView.findViewById(R.id.imagePelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.titulo.text = pelicula.titulo
        holder.imagen.setImageResource(pelicula.imagen)
        holder.itemView.setOnClickListener { onItemClick(pelicula) }
    }

    override fun getItemCount(): Int = peliculas.size
}