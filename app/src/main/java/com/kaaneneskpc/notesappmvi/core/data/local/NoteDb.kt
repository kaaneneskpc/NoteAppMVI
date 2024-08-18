package com.kaaneneskpc.notesappmvi.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDb: RoomDatabase() {
    abstract val noteDao: NoteDao
}