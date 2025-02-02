package com.miproyecto.EcoGps

import android.app.Application
import androidx.room.Room

class EcoGpsApplication : Application() {

    companion object {
        lateinit var database: EcoGpsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        // Inicialización de la base de datos Room
        database = Room.databaseBuilder(
            applicationContext,
            EcoGpsDatabase::class.java,
            "eco_gps_database"
        ).build()
    }
}
