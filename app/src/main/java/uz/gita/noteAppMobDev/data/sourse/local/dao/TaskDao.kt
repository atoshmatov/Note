package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

@Dao
interface TaskDao : BaseDao<TaskEntity> {

    @Query("SELECT * FROM TaskEntity")
    fun getTasks(): List<TaskEntity>
}