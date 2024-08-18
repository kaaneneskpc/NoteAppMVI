package com.kaaneneskpc.notesappmvi.core.data.repository

import com.kaaneneskpc.notesappmvi.core.data.local.NoteDb
import com.kaaneneskpc.notesappmvi.core.data.mapper.toNoteEntityForDelete
import com.kaaneneskpc.notesappmvi.core.data.mapper.toNoteEntityForInsert
import com.kaaneneskpc.notesappmvi.core.data.mapper.toNoteItem
import com.kaaneneskpc.notesappmvi.core.domain.model.NoteItem
import com.kaaneneskpc.notesappmvi.core.domain.repository.NoteRepository

class NoteRepositoryImpl(
    noteDb: NoteDb
) : NoteRepository {

    private val noteDao = noteDb.noteDao

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteDao.deleteNoteEntity(noteItem.toNoteEntityForDelete())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNoteEntities().map { it.toNoteItem() }
    }
}