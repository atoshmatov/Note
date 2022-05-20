package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModelImpl
@Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : AddNoteViewModel, ViewModel() {
    override val backLiveData = MutableLiveData<Unit>()


    override fun addNewNote(noteData: NoteData) {
        /*viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.addNote(noteData).collect()
        }*/
        addNoteUseCase.addNote(noteData)
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    override fun back() {
        backLiveData.value = Unit
    }
}