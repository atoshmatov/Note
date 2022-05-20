package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity


interface NoteViewModel {

    val notesLiveData: LiveData<List<NoteEntity>>
    val pleaseHolderLiveData: LiveData<Boolean>

    fun loadNotes()
    fun deleteNote(noteData: NoteData)

}