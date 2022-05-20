package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.domain.usecase.UpdateNoteUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.UpdateNoteViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModelImpl @Inject constructor(
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel(), UpdateNoteViewModel {
    override val successLiveData = MutableLiveData<String>()
    override val backLiveData = MutableLiveData<Unit>()

    override fun updateNote(noteData: NoteData) {
        updateNoteUseCase.update(noteData).onEach {
            it.onSuccess {
                successLiveData.value = "Update"
            }
        }.launchIn(viewModelScope)

//        updateNoteUseCase.update(noteData)
//            .flowOn(Dispatchers.IO)
//            .launchIn(viewModelScope)
    }

    override fun back() {
        backLiveData.value = Unit
    }
}