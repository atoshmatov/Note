package uz.gita.noteAppMobDev.domain.repository

import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskRepository {
    suspend fun addTasks(taskEntity: TaskEntity)
    suspend fun getTasks(): List<TaskEntity>
    suspend fun deleteTask(taskEntity: TaskEntity)
    suspend fun update(taskEntity: TaskEntity)
}