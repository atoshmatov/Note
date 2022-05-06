package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.common.models.NoteData

interface NoteUseCase {
    fun getNotes(): Flow<List<NoteData>>

    suspend fun addNote(noteData: NoteData)
}