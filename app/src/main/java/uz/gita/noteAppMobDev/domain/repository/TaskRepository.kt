package uz.gita.noteAppMobDev.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskRepository {

    suspend fun addTasks(taskEntity: TaskEntity)

    fun getTasks(): Flow<List<TaskEntity>>
}