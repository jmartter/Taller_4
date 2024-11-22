package com.example.taller4

import android.content.Intent
import android.widget.RemoteViewsService

class PeliculasWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return PeliculasRemoteViewsFactory(this.applicationContext)
    }
}