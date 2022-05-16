package uz.gita.noteAppMobDev.data.common.models

import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import java.io.Serializable

data class NoteData(
    val id: Long = 0,
    val title: String,
    val description: String,
    val time: Long = 0
) : Serializable

fun NoteData.toEntity() = NoteEntity(id = id, title = title, description = description, time = time)
