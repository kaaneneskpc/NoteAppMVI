package com.kaaneneskpc.notesappmvi.core.di

import android.app.Application
import androidx.room.Room
import com.kaaneneskpc.notesappmvi.addNote.domain.usecase.SearchImages
import com.kaaneneskpc.notesappmvi.addNote.domain.usecase.UpsertNote
import com.kaaneneskpc.notesappmvi.core.data.local.NoteDb
import com.kaaneneskpc.notesappmvi.core.data.remote.ImagesApi
import com.kaaneneskpc.notesappmvi.core.data.repository.ImagesRepositoryImpl
import com.kaaneneskpc.notesappmvi.core.data.repository.NoteRepositoryImpl
import com.kaaneneskpc.notesappmvi.core.domain.repository.ImagesRepository
import com.kaaneneskpc.notesappmvi.core.domain.repository.NoteRepository
import com.kaaneneskpc.notesappmvi.noteList.domain.usecase.DeleteNote
import com.kaaneneskpc.notesappmvi.noteList.domain.usecase.GetAllNotes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNoteRepository(
        noteDb: NoteDb
    ): NoteRepository {
        return NoteRepositoryImpl(noteDb)
    }

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(
        noteRepository: NoteRepository
    ): GetAllNotes {
        return GetAllNotes(noteRepository)
    }


    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(
        noteRepository: NoteRepository
    ): DeleteNote {
        return DeleteNote(noteRepository)
    }

    @Provides
    @Singleton
    fun provideUpsertNoteUseCase(
        noteRepository: NoteRepository
    ): UpsertNote {
        return UpsertNote(noteRepository)
    }


    @Provides
    @Singleton
    fun provideImageApi(): ImagesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ImagesApi.BASE_URL)
            .build()
            .create(ImagesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImagesRepository(
        imagesApi: ImagesApi
    ): ImagesRepository {
        return ImagesRepositoryImpl(imagesApi)
    }

    @Provides
    @Singleton
    fun provideSearchImagesUseCase(
        imagesRepository: ImagesRepository
    ): SearchImages {
        return SearchImages(imagesRepository)
    }

}