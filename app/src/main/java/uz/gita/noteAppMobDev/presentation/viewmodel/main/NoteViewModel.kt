package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.NoteData

interface NoteViewModel {

    val notesLiveData : LiveData<List<NoteData>>

    //temp
    fun addNote(noteData: NoteData)
}