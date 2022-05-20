package uz.gita.noteAppMobDev.data.common.models

import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import java.io.Serializable

data class TaskData(
    val id: Long = 0,
    val title: String,
    val time: Long = 0,
    val selected: Int = 0
) : Serializable

fun TaskData.toEntity() = TaskEntity(id = id, title = title, time = time, selected = selected)
