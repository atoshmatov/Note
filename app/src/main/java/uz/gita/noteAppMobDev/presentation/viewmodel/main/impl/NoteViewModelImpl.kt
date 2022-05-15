package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.domain.usecase.NoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModelImpl
@Inject constructor(
    private val useCaseNote: NoteUseCase
) : NoteViewModel,
    ViewModel() {
    override val notesLiveData = MutableLiveData<List<NoteEntity>>()
    override val errorLiveData = MutableLiveData<String>()

    override fun loadNotes() {
        useCaseNote.getNotes().onEach {
            it.onSuccess { note ->
                notesLiveData.value = note
            }.onFailure {
                errorLiveData.value = "Error"
            }
        }.launchIn(viewModelScope)
    }
}
