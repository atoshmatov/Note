package uz.gita.noteAppMobDev.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import uz.gita.noteAppMobDev.domain.repository.TaskRepository
import uz.gita.noteAppMobDev.domain.repository.impl.NoteRepositoryImpl
import uz.gita.noteAppMobDev.domain.repository.impl.TaskRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository

    @[Binds Singleton]
    fun bindTaskRepository(impl: TaskRepositoryImpl): TaskRepository

}