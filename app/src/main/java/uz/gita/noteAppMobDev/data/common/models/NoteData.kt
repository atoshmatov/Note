package uz.gita.noteAppMobDev.data.common.models

import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

data class NoteData(
    val id: Long = 0,
    val title: String,
    val description: String,
    val time: String
)


fun NoteData.toEntity() = NoteEntity(title = title, description = description, time = time)
