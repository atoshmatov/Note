package uz.gita.noteAppMobDev.data.sourse.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.noteAppMobDev.data.sourse.local.dao.NoteDao
import uz.gita.noteAppMobDev.data.sourse.local.dao.TaskDao
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

@Database(entities = [NoteEntity::class, TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
    abstract fun getTaskDao(): TaskDao
}