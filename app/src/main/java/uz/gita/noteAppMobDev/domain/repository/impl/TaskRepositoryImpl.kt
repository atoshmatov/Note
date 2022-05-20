package uz.gita.noteAppMobDev.domain.repository.impl

import uz.gita.noteAppMobDev.data.sourse.local.dao.TaskDao
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import uz.gita.noteAppMobDev.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl
@Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun addTasks(taskEntity: TaskEntity) {
        taskDao.insert(taskEntity)
    }

    override suspend fun deleteTask(taskEntity: TaskEntity) {
        taskDao.delete(taskEntity)
    }

    override suspend fun update(taskEntity: TaskEntity) {
        taskDao.upDate(taskEntity)
    }

    override suspend fun checkAdd(id: Long) {
        taskDao.addCheck(id)
    }

    override suspend fun checkDelete(id: Long) {
        taskDao.deleteCheck(id)
    }

    override suspend fun getTasks(): List<TaskEntity> = taskDao.getTasks()
}
