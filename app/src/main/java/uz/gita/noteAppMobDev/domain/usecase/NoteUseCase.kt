package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

interface NoteUseCase {
    fun getNotes(): Flow<Result<List<NoteEntity>>>
}