package com.miproyecto.EcoGps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val dao = EcoGpsApplication.database.puntoDeReciclajeDao()

    private val _puntosReciclaje = MutableStateFlow<List<PuntoDeReciclaje>>(emptyList())
    val puntosReciclaje: StateFlow<List<PuntoDeReciclaje>> = _puntosReciclaje

    init {
        viewModelScope.launch {
            _puntosReciclaje.value = dao.getAll()
        }
    }

    fun addPunto(punto: PuntoDeReciclaje) {
        viewModelScope.launch {
            dao.insert(punto)
            _puntosReciclaje.value = dao.getAll()
        }
    }
}
