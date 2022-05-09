package uz.gita.noteAppMobDev.data.common.models

import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

data class TaskData(
    val id: Long = 0,
    val title: String,
    val time: String,
    val selected: Boolean = false
)

fun TaskData.toEntity() = TaskEntity(title = title, time = time)
