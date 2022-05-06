package uz.gita.noteAppMobDev.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import uz.gita.noteAppMobDev.domain.usecase.MainUseCase
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import uz.gita.noteAppMobDev.domain.usecase.impl.AddNoteUseCaseImpl
import uz.gita.noteAppMobDev.domain.usecase.impl.MainUseCaseImpl
import uz.gita.noteAppMobDev.domain.usecase.impl.NoteUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindNoteUseCase(impl: NoteUseCaseImpl): NoteUseCase

    @Binds
    fun bindAddNoteUseCase(impl: AddNoteUseCaseImpl): AddNoteUseCase

    @Binds
    fun bindMainUseCase(impl: MainUseCaseImpl): MainUseCase
}