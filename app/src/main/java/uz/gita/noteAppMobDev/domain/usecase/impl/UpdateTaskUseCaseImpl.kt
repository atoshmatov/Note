package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.TaskRepository
import uz.gita.noteAppMobDev.domain.usecase.UpdateTaskUseCase
import javax.inject.Inject

class UpdateTaskUseCaseImpl @Inject constructor(
    private val taskRepository: TaskRepository
) : UpdateTaskUseCase {
    override fun update(taskData: TaskData) = flow<Result<Unit>> {
        taskRepository.update(taskData.toEntity())
        emit(Result.success(Unit))
    }.flowOn(Dispatchers.IO)
}