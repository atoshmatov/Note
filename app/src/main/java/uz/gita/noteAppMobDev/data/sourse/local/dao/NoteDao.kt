package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

@Dao
interface NoteDao : BaseDao<NoteEntity> {
    @Query("SELECT * FROM NoteEntity ORDER BY time DESC")
    fun getNotes(): List<NoteEntity>
}