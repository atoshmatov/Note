package uz.gita.noteAppMobDev.domain.repository

import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskRepository {
    // add task
    suspend fun addTasks(taskEntity: TaskEntity)

    //getAll task
    suspend fun getTasks(): List<TaskEntity>

    // delete task
    suspend fun deleteTask(taskEntity: TaskEntity)

    // update task
    suspend fun update(taskEntity: TaskEntity)

    // set select task
    suspend fun checkAdd(id: Long)

    // delete select task
    suspend fun checkDelete(id: Long)
}
