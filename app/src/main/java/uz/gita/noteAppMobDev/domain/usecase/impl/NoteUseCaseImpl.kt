package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import javax.inject.Inject

class NoteUseCaseImpl
@Inject constructor(
    private val noteRepository: NoteRepository
) : NoteUseCase {
    override fun getNotes() = flow<Result<List<NoteEntity>>> {
        emit(
            Result.success(
                noteRepository.getNotes().sortedWith { p0, p1 -> (p1.time - p0.time).toInt() })
        )
    }.flowOn(Dispatchers.IO)

    override fun delete(noteData: NoteData) = flow<Result<Unit>> {
        emit(Result.success(noteRepository.deleteNote(noteData.toEntity())))
    }.flowOn(Dispatchers.IO)

    override fun update(noteData: NoteData) = flow<Result<Unit>> {
        emit(Result.success(noteRepository.updateNote(noteData.toEntity())))
    }.flowOn(Dispatchers.IO)
}