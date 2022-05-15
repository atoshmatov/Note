package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskUseCase {
    fun getTasks(): Flow<Result<List<TaskEntity>>>
}