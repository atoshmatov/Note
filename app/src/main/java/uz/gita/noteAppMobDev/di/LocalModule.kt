package uz.gita.noteAppMobDev.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.noteAppMobDev.data.sourse.local.AppDatabase
import uz.gita.noteAppMobDev.data.sourse.local.dao.NoteDao
import uz.gita.noteAppMobDev.data.sourse.local.dao.TaskDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @[Provides Singleton]
    fun getAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "MyNote").build()

    @[Provides Singleton]
    fun getNoteDao(database: AppDatabase) : NoteDao = database.getNoteDao()

    @[Provides Singleton]
    fun getTaskDao(database: AppDatabase) : TaskDao = database.getTaskDao()
}