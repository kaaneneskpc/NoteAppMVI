package com.kaaneneskpc.notesappmvi.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    var title: String,
    var description: String,
    var imageUrl: String,

    var dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)