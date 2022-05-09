package uz.gita.noteAppMobDev.domain.repository

import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

interface NoteRepository {

    // add notes
    suspend fun addNote(noteEntity: NoteEntity)

    // getAll notes
    suspend fun getNotes(): List<NoteEntity>
}