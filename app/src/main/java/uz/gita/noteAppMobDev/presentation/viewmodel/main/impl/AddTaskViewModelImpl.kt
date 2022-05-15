package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.domain.usecase.AddTaskUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddTaskViewModel
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModelImpl
@Inject constructor(
    private val addTaskUseCase: AddTaskUseCase
) :
    ViewModel(), AddTaskViewModel {
    override val backLiveData = MutableLiveData<Unit>()

    override fun addNewTask(taskData: TaskData) {
        /*addTaskUseCase.addTask(taskData)
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)*/
        viewModelScope.launch(Dispatchers.IO) {
            addTaskUseCase.addTask(taskData).collect()
        }
        return
    }

    override fun back() {
        backLiveData.value = Unit
    }
}