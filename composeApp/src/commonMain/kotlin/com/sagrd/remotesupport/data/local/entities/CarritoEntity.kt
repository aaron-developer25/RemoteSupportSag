package org.aarondeveloper.ejemplo1.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Carritos")
data class CarritoEntity(
    @PrimaryKey
    val carritoId: Int,
    val usuarioId: Int,
    val productoId: Int,
    val cantidad: Int
)