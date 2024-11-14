package com.sagrd.remotesupport.data.local.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.sun.tools.javac.util.Context
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<SagDB> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), DATABASE_NAME)
    return Room.databaseBuilder<SagDB>(
        name = dbFile.absolutePath,
    )
}
