package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.common.models.TaskData

interface UpdateTaskUseCase {
    fun update(taskData: TaskData): Flow<Result<Unit>>
}