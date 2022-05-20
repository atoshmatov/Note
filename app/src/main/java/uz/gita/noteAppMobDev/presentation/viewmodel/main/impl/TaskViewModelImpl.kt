package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import uz.gita.noteAppMobDev.domain.usecase.TaskUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.TaskViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModelImpl
@Inject constructor(
    private val taskUseCase: TaskUseCase
) : ViewModel(), TaskViewModel {
    override val tasksLiveData = MutableLiveData<List<TaskEntity>>()
    override val successLiveData = MutableLiveData<String>()
    override val pleaseHolderLiveData = MutableLiveData<Boolean>()

    override fun loadTask() {
        taskUseCase.getTasks().onEach {
            it.onSuccess { task ->
                tasksLiveData.value = task
                pleaseHolderLiveData.value = task.isEmpty()
            }
        }.launchIn(viewModelScope)
    }

    override fun addChecked(id: Long) {
        taskUseCase.addCheck(id).onEach {
            it.onSuccess {
                loadTask()
            }
        }.launchIn(viewModelScope)
    }

    override fun deleteChecked(id: Long) {
        taskUseCase.deleteCheck(id).onEach {
            it.onSuccess {
                loadTask()
            }
        }.launchIn(viewModelScope)
    }

    override fun deleteTask(taskData: TaskData) {
        taskUseCase.deleteTask(taskData).onEach {
            it.onSuccess {
                successLiveData.value = "Delete"
                loadTask()
            }
        }.launchIn(viewModelScope)
    }
}