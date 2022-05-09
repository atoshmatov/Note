package uz.gita.noteAppMobDev.domain.usecase.impl

import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.usecase.TaskUseCase
import javax.inject.Inject

class AddTaskUseCaseImpl
@Inject constructor
    (
    private val noteRepository: NoteRepository
):TaskUseCase {


}