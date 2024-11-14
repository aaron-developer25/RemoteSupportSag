package com.sagrd.remotesupport.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.aarondeveloper.ejemplo1.data.local.dao.CarritoDao
import org.aarondeveloper.ejemplo1.data.local.entities.CarritoEntity

const val DATABASE_NAME = "sag.db"

@Database(
    entities = [
        CarritoEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class SagDB : RoomDatabase() {
    abstract fun carritoDao(): CarritoDao
}