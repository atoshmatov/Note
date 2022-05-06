package uz.gita.noteAppMobDev.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

interface NoteRepository {

    suspend fun createNote(noteEntity: NoteEntity)

    fun getNotes():Flow<List<NoteEntity>>
}