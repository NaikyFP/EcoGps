package com.miproyecto.EcoGps

import androidx.room.*

@Dao
interface PuntoDeReciclajeDao {
    @Query("SELECT * FROM puntos_reciclaje")
    suspend fun getAll(): List<PuntoDeReciclaje>

    @Insert
    suspend fun insert(punto: PuntoDeReciclaje)
}
