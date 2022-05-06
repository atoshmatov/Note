package uz.gita.noteAppMobDev.domain.usecase

import uz.gita.noteAppMobDev.data.common.models.NoteData

interface AddNoteUseCase {

    suspend fun addNote(noteData: NoteData)
}