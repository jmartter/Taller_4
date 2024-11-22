package com.example.taller4

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class PeliculasRemoteViewsFactory(private val context: Context) : RemoteViewsService.RemoteViewsFactory {

    private var peliculas: List<Pelicula> = emptyList()

    override fun onCreate() {
        // No-op
    }

    override fun onDataSetChanged() {
        peliculas = PeliculaRepository.obtenerPeliculas()
    }

    override fun onDestroy() {
        // No-op
    }

    override fun getCount(): Int = peliculas.size

    override fun getViewAt(position: Int): RemoteViews {
        val pelicula = peliculas[position]
        val views = RemoteViews(context.packageName, android.R.layout.simple_list_item_1)
        views.setTextViewText(android.R.id.text1, pelicula.titulo)
        return views
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = true
}