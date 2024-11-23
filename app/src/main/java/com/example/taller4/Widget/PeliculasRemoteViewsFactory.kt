package com.example.taller4.Widget

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.taller4.Peliculas.PeliculaRepository

class PeliculasRemoteViewsFactory(private val context: Context) : RemoteViewsService.RemoteViewsFactory {

    private var titulos: List<String> = emptyList()

    override fun onCreate() {
        // No-op
    }

    override fun onDataSetChanged() {
        titulos = PeliculaRepository.obtenerTitulosDePeliculas()
    }

    override fun onDestroy() {
        // No-op
    }

    override fun getCount(): Int = titulos.size

    override fun getViewAt(position: Int): RemoteViews {
        val titulo = titulos[position]
        val views = RemoteViews(context.packageName, android.R.layout.simple_list_item_1)
        views.setTextViewText(android.R.id.text1, titulo)
        return views
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = true
}