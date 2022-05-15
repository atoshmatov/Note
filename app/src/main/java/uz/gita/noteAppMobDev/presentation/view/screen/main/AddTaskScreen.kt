package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.databinding.ScreenAddtaskBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddTaskViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.AddTaskViewModelImpl

@AndroidEntryPoint
class AddTaskScreen : Fragment(R.layout.screen_addtask) {
    private val binding by viewBinding(ScreenAddtaskBinding::bind)
    private val viewModel: AddTaskViewModel by viewModels<AddTaskViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        addTask.setOnClickListener {
            viewModel.addNewTask(
                TaskData(
                    title = taskAddTittle.text.toString(),
                    time = System.currentTimeMillis()
                )
            )
            viewModel.back()
        }
        viewModel.backLiveData.observe(viewLifecycleOwner, backObserver)
    }

    private val backObserver = Observer<Unit> {
        findNavController().popBackStack()
    }

}