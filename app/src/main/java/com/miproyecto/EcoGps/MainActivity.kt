package com.miproyecto.EcoGps

import android.os.Bundle
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoGpsTheme {
                MainScreen()
            }
        }
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
