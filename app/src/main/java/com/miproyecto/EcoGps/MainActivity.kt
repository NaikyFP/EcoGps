package com.miproyecto.EcoGps

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miproyecto.EcoGps.ui.theme.EcoGpsTheme

class EcoGpsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("EcoGpsApplication", "Aplicación Iniciada.")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.w("EcoGpsApplication", "Poca memoria disponible.")
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate llamado: La actividad se está creando.")
        setContent {
            EcoGpsTheme {
                MainScreen()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart llamado: La actividad está siendo visible.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainAcitivty", "onResume llamado: La actividad está interactuando con el usuario.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivty", "onPause LLAMADO: La actividad ya no esta interactuando con el usuario.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop llamado: La actividad ya no es visible.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy llamado: La actividad se está destruyendo")
    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("EcoGPS")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Encuentra puntos de reciclaje y áreas verdes cercanas.",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.reciclaje),
                contentDescription = "Recycling Icon",
                modifier = Modifier
                    .size(120.dp)
                    .align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sampleData) { item ->
                    ListItem(
                        headlineContent = { Text(item.name) },
                        supportingContent = { Text("Dirección: ${item.address}") },
                        trailingContent = { Text(item.type) }
                    )
                }
            }
        }
    }
}

val sampleData = listOf(
    PuntoDeReciclaje("Punto A", "Calle 123", "Plástico"),
    PuntoDeReciclaje("Punto B", "Calle 456", "Vidrio"),
    PuntoDeReciclaje("Punto C", "Calle 789", "Papel")
)

data class PuntoDeReciclaje(val name: String, val address: String, val type: String)

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    EcoGpsTheme {
        MainScreen()
    }
}
