package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.toData
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import javax.inject.Inject

class NoteUseCaseImpl
@Inject constructor(
    private val noteRepository: NoteRepository
) : NoteUseCase {

}