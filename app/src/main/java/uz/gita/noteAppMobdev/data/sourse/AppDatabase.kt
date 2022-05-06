package uz.gita.noteAppMobdev.data.sourse

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.noteAppMobdev.data.sourse.dao.NoteDao
import uz.gita.noteAppMobdev.data.sourse.dao.TaskDao

//@Database(entities = [NoteEntity::class, TaskEntity::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun getNoteDao(): NoteDao
//    abstract fun getTaskDao(): TaskDao
//}