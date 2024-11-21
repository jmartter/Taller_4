package com.example.taller4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taller4.ui.theme.Taller4Theme
import java.util.*

class PantallaDeInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller4Theme {
                InicioScreen {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun InicioScreen(onButtonClick: () -> Unit) {
    val greeting = getGreetingMessage()
    val imageRes = when (greeting) {
        "Buenas tardes" -> R.drawable.tarde
        "Buenas noches" -> R.drawable.noche
        else -> null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        imageRes?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = greeting,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onButtonClick) {
                    Text(text = "Actividad Principal")
                }
            }
        }
        imageRes?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

fun getGreetingMessage(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 0..11 -> "Buenos días"
        in 12..17 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    Taller4Theme {
        InicioScreen {}
    }
}