package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.TaskData

interface AddTaskViewModel {
    //event
    val backLiveData: LiveData<Unit>

    //action
    fun addNewTask(taskData: TaskData)
    fun back()
}