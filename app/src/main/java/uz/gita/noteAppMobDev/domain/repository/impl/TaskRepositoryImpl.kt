package uz.gita.noteAppMobDev.domain.repository.impl

import kotlinx.coroutines.flow.Flow
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
    override fun getTasks(): Flow<List<TaskEntity>> = taskDao.getTasks()
}