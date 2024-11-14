package org.aarondeveloper.ejemplo1.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.aarondeveloper.ejemplo1.data.local.entities.CarritoEntity

@Dao
interface CarritoDao {
    @Upsert
    suspend fun save(carrito: CarritoEntity)

    @Query("SELECT * FROM Carritos WHERE carritoId = :id LIMIT 1")
    suspend fun findById(id: Int): CarritoEntity?

    @Delete
    suspend fun delete(carrito: CarritoEntity)

    @Query("SELECT * FROM Carritos")
    fun getAll(): Flow<List<CarritoEntity>>

}