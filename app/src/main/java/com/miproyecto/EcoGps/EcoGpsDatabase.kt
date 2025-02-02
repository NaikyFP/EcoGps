package com.miproyecto.EcoGps

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PuntoDeReciclaje::class], version = 1)
abstract class EcoGpsDatabase : RoomDatabase() {
    abstract fun puntoDeReciclajeDao(): PuntoDeReciclajeDao
}