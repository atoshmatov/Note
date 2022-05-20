package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.domain.usecase.UpdateTaskUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.UpdateTaskViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateTaskViewModelImpl @Inject constructor(
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel(), UpdateTaskViewModel {
    override val successLiveData = MutableLiveData<String>()
    override val backLiveData = MutableLiveData<Unit>()

    override fun updateTask(taskData: TaskData) {
        updateTaskUseCase.update(taskData)
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    override fun back() {
        backLiveData.value = Unit
    }
}