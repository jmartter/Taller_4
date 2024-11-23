package com.example.taller4

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.commit
import com.example.taller4.Fragments.DetallesPeliculaFragment
import com.example.taller4.Fragments.GestionPeliculasFragment
import com.example.taller4.Fragments.ListaPeliculasFragment
import com.example.taller4.Peliculas.Pelicula
import com.example.taller4.Peliculas.PeliculaRepository

class MainActivity : AppCompatActivity(), SensorEventListener {
    private var peliculaSeleccionada: Pelicula? = null
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.mainLayout)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        supportFragmentManager.commit {
            replace(R.id.fragmentContainerLista, ListaPeliculasFragment())
            replace(R.id.fragmentContainerDetalles, DetallesPeliculaFragment())
            replace(R.id.fragmentContainerGestion, GestionPeliculasFragment())
        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val x = it.values[0]
            val y = it.values[1]
            val z = it.values[2]

            val acceleration = Math.sqrt((x * x + y * y + z * z).toDouble())
            if (acceleration > 15) {
                layout.setBackgroundColor(Color.rgb((0..255).random(), (0..255).random(), (0..255).random()))
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No-op
    }

    fun mostrarDetallesPelicula(pelicula: Pelicula) {
        peliculaSeleccionada = pelicula
        val detallesFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerDetalles) as? DetallesPeliculaFragment
        detallesFragment?.mostrarDetalles(pelicula)
    }

    fun borrarPeliculaSeleccionada() {
        peliculaSeleccionada?.let { pelicula ->
            PeliculaRepository.borrarPelicula(pelicula)
            peliculaSeleccionada = null
            actualizarListaPeliculas()
        }
    }

    fun actualizarListaPeliculas() {
        val listaFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerLista) as? ListaPeliculasFragment
        listaFragment?.actualizarLista()
    }
}