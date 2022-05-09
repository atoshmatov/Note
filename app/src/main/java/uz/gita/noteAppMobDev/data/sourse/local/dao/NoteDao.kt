package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

@Dao
interface NoteDao : BaseDao<NoteEntity> {

    @Query("SELECT * FROM NoteEntity")
    fun getNotes(): List<NoteEntity>
}