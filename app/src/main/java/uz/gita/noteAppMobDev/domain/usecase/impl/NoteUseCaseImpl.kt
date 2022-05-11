package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import javax.inject.Inject

class NoteUseCaseImpl
@Inject constructor(
    private val noteRepository: NoteRepository
) : NoteUseCase {
    override fun getNotes() = flow<Result<List<NoteEntity>>> {
        emit(Result.success(noteRepository.getNotes()))
    }.flowOn(Dispatchers.IO)
}