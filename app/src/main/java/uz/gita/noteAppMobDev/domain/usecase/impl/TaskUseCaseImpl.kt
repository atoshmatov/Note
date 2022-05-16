package uz.gita.noteAppMobDev.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.common.models.toEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import uz.gita.noteAppMobDev.domain.repository.TaskRepository
import uz.gita.noteAppMobDev.domain.usecase.TaskUseCase
import javax.inject.Inject

class TaskUseCaseImpl
@Inject constructor(
    private val taskRepository: TaskRepository
) :
    TaskUseCase {
    override fun getTasks() = flow<Result<List<TaskEntity>>> {
        emit(
            Result.success(
                taskRepository.getTasks().sortedWith { p0, p1 -> (p1.time - p0.time).toInt() })
        )
    }.flowOn(Dispatchers.IO)

    override fun addCheck(id: Long) = flow<Result<Unit>> {
        emit(Result.success(taskRepository.checkAdd(id)))
    }.flowOn(Dispatchers.IO)

    override fun deleteCheck(id: Long) = flow<Result<Unit>> {
        emit(Result.success(taskRepository.checkDelete(id)))
    }.flowOn(Dispatchers.IO)

    override fun deleteTask(taskData: TaskData) = flow<Result<Unit>> {
        emit(Result.success(taskRepository.deleteTask(taskData.toEntity())))
    }.flowOn(Dispatchers.IO)
}