package uz.gita.noteAppMobDev.data.sourse.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey
    val id: Long
)