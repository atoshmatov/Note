package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.NoteData

interface AddNoteViewModel {

    val backLiveData: LiveData<Unit>

    //add new note
    fun addNewNote(noteData: NoteData)
    fun back()
}