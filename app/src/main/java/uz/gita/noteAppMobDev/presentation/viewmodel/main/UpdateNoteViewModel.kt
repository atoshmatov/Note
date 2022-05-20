package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.NoteData

interface UpdateNoteViewModel {
    val successLiveData: LiveData<String>
    val backLiveData: LiveData<Unit>

    fun updateNote(noteData: NoteData)
    fun back()
}