package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity

interface TaskViewModel{

    val tasksLiveData: LiveData<List<TaskEntity>>
    val successLiveData:LiveData<String>
    val pleaseHolderLiveData: LiveData<Boolean>


    fun loadTask()
    fun addChecked(id:Long)
    fun deleteChecked(id:Long)
    fun deleteTask(taskData: TaskData)

}