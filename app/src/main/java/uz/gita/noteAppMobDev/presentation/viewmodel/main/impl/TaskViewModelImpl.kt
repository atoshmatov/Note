package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
    override val errorLiveData = MutableLiveData<String>()

    override fun loadTask() {
        taskUseCase.getTasks().onEach {
            it.onSuccess { task ->
                tasksLiveData.value = task
            }.onFailure {
                errorLiveData.value = "Error"
            }
        }.launchIn(viewModelScope)
    }
}