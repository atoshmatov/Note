package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

@Dao
interface TaskDao : BaseDao<TaskEntity> {
    // getAll tasks
    @Query("SELECT * FROM TaskEntity")
    fun getTasks(): List<TaskEntity>

    //add select task
    @Query("update  TaskEntity set selected = 1 where id=:id")
    fun addCheck(id: Long)

    //delete select task
    @Query("update  TaskEntity set selected = 0 where id=:id")
    fun deleteCheck(id: Long)
}