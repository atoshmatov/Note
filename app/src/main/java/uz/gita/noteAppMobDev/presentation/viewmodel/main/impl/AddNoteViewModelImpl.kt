package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.domain.usecase.AddNoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModelImpl @Inject constructor(private val useCase: AddNoteUseCase) : AddNoteViewModel, ViewModel() {
    override val errorTitleLiveData: MutableLiveData<Int> = MutableLiveData()
    override val errorDescriptionLiveData: MutableLiveData<Int> = MutableLiveData()
    override val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    override val successLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun addNewNote(noteData: NoteData) {
        when {
            noteData.title.trim().isEmpty() -> errorTitleLiveData.value = R.string.title_empty
            noteData.description.trim().isEmpty() -> errorDescriptionLiveData.value = R.string.description_empty
            else -> {
                viewModelScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) { useCase.addNote(noteData) }
                }
            }
        }
    }

    override fun back() {
        backLiveData.value = Unit
    }
}