package com.kaaneneskpc.notesappmvi.core.di

import android.app.Application
import androidx.room.Room
import com.kaaneneskpc.notesappmvi.core.data.local.NoteDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDb(application: Application): NoteDb {
        return Room.databaseBuilder(
            application,
            NoteDb::class.java,
            "note_db.db"
        ).build()
    }
}