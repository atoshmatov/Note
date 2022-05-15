package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskViewModel{

    val tasksLiveData: LiveData<List<TaskEntity>>
    val errorLiveData: LiveData<String>

    fun loadTask()

}