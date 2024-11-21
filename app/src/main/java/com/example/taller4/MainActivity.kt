package com.example.taller4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, PantallaDeInicio::class.java)
        startActivity(intent)
        finish() // Opcional: Finaliza MainActivity para que no esté en el back stack
    }
}