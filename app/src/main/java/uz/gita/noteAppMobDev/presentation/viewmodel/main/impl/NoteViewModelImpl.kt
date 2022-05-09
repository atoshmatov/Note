package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModelImpl @Inject constructor(private val useCase: NoteUseCase) : NoteViewModel,
    ViewModel() {

}
