package uz.gita.noteAppMobDev.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.noteAppMobDev.domain.usecase.*
import uz.gita.noteAppMobDev.domain.usecase.impl.*

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindNoteUseCase(impl: NoteUseCaseImpl): NoteUseCase

    @Binds
    fun bindAddNoteUseCase(impl: AddNoteUseCaseImpl): AddNoteUseCase

    @Binds
    fun bindTaskUseCase(impl: TaskUseCaseImpl): TaskUseCase

    @Binds
    fun bindAddTaskUseCase(impl: AddTaskUseCaseImpl): AddTaskUseCase

    @Binds
    fun bindMainUseCase(impl: MainUseCaseImpl): MainUseCase

    @Binds
    fun bindUpdateUseCase(impl: UpdateNoteUseCaseImpl): UpdateNoteUseCase

    @Binds
    fun bindUpdateTaskUseCase(impl: UpdateTaskUseCaseImpl): UpdateTaskUseCase

}