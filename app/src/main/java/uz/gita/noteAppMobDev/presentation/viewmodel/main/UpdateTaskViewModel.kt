package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.noteAppMobDev.data.common.models.TaskData

interface UpdateTaskViewModel {
    val successLiveData: LiveData<String>
    val backLiveData: LiveData<Unit>

    fun updateTask(taskData: TaskData)
    fun back()
}