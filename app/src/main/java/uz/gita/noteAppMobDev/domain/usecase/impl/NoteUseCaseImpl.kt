package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.toData
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import javax.inject.Inject

class NoteUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository) : NoteUseCase {

    override fun getNotes(): Flow<List<NoteData>> = flow {
        noteRepository.getNotes().collect { notes -> emit(notes.map { it.toData() }) }
    }

    override suspend fun addNote(noteData: NoteData) = noteRepository.createNote(noteData.toEntity())
}