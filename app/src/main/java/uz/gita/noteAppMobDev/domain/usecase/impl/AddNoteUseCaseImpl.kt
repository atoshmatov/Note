package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl
@Inject constructor(
    private val noteRepository: NoteRepository
) : AddNoteUseCase {
    override fun addNote(noteData: NoteData) = flow<Result<Unit>> {
        emit(Result.success(noteRepository.addNote(noteData.toEntity())))
    }.flowOn(Dispatchers.IO)

}