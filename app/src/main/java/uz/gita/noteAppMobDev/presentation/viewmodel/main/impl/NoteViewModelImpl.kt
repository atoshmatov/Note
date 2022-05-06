package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModelImpl @Inject constructor(private val useCase: NoteUseCase) : NoteViewModel, ViewModel() {
    override val notesLiveData: MutableLiveData<List<NoteData>> = MutableLiveData()

    init {
        viewModelScope.launch {
            useCase.getNotes()
                .flowOn(Dispatchers.Default)
                .onEach { notesLiveData.value = it }
                .flowOn(Dispatchers.Main)
                .launchIn(viewModelScope)
        }
    }

    override fun addNote(noteData: NoteData) {
        viewModelScope.launch(Dispatchers.IO) { useCase.addNote(noteData) }
    }
}