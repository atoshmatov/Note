package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModelImpl
@Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : AddNoteViewModel, ViewModel() {
    override val errorTitleLiveData = MutableLiveData<Int>()
    override val errorDescriptionLiveData = MutableLiveData<Int>()
    override val loadingLiveData = MutableLiveData<Boolean>()
    override val successLiveData = MutableLiveData<Unit>()
    override val backLiveData = MutableLiveData<Unit>()


    override fun addNewNote(noteData: NoteData) {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.addNote(noteData)
        }
        loadingLiveData.value = true
        return
    }

    override fun back() {
        backLiveData.value = Unit
    }
}