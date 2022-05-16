package uz.gita.noteAppMobDev.data.sourse.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.noteAppMobDev.data.common.models.TaskData

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val time: Long = 0,
    val selected: Int = 0
)

fun TaskEntity.toTaskData() = TaskData(id, title, time, selected)