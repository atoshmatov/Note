package uz.gita.noteAppMobDev.data.sourse.local.dao

import androidx.room.*
import kotlinx.coroutines.selects.select

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T)

    @Update
    fun upDate(t: T)

    @Delete
    fun delete(t: T)
}