package uz.gita.noteAppMobDev.domain.usecase.impl

import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository) : AddNoteUseCase {

    override suspend fun addNote(noteData: NoteData) = noteRepository.createNote(noteData.toEntity())
}