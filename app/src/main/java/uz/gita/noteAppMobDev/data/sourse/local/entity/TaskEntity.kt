package uz.gita.noteAppMobDev.data.sourse.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val time: Long = 0,
    val selected: Boolean = false
)

fun TaskEntity.toTaskData() = TaskEntity(id, title, time, selected)