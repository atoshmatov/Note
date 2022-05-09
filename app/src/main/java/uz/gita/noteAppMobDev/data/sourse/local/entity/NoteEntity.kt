package uz.gita.noteAppMobDev.data.sourse.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.noteAppMobDev.data.common.models.NoteData

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val time: String
)
fun NoteEntity.toData() = NoteData(id, title, description, time)