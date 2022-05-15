package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.domain.repository.TaskRepository
import uz.gita.noteAppMobDev.domain.usecase.AddTaskUseCase
import javax.inject.Inject

class AddTaskUseCaseImpl
@Inject constructor(
    private val taskRepository: TaskRepository
) : AddTaskUseCase {
    override fun addTask(taskData: TaskData) = flow<Result<Unit>> {
        emit(Result.success(taskRepository.addTasks(taskData.toEntity())))
    }.flowOn(Dispatchers.IO)
}