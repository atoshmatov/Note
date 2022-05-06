package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity

@Dao
interface NoteDao : BaseDao<NoteEntity> {

    @Query("SELECT * FROM NoteEntity")
    fun getNotes(): Flow<List<NoteEntity>>
}