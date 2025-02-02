package com.miproyecto.EcoGps

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miproyecto.EcoGps.ui.theme.EcoGpsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoGpsTheme {
                // Conectamos el ViewModel
                val viewModel: MainViewModel = viewModel()
                MainScreen(viewModel = viewModel)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart llamado: La actividad está siendo visible.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume llamado: La actividad está interactuando con el usuario.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause llamado: La actividad ya no está interactuando con el usuario.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop llamado: La actividad ya no es visible.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy llamado: La actividad se está destruyendo.")
    }
}
