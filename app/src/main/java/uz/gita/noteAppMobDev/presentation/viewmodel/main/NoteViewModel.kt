package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity


interface NoteViewModel {

    val notesLiveData: LiveData<List<NoteEntity>>
    val errorLiveData: LiveData<String>
    val successLiveData: LiveData<String>

    fun loadNotes()
    fun deleteNote(noteData: NoteData)

}