package com.miproyecto.EcoGps

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "puntos_reciclaje")
data class PuntoDeReciclaje(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val address: String,
    val type: String
)
