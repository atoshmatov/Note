package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.common.models.TaskData


interface AddTaskUseCase {
    fun addTask(taskData: TaskData): Flow<Result<Unit>>
}