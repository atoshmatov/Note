package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.UpdateNoteUseCase
import javax.inject.Inject

class UpdateNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : UpdateNoteUseCase {
    override fun update(noteData: NoteData) = flow<Result<Unit>> {
        noteRepository.updateNote(noteData.toEntity())
        emit(Result.success(Unit))
    }.flowOn(Dispatchers.IO)
}