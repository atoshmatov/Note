package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.TaskData
import uz.gita.noteAppMobDev.databinding.ScreenUpdatetasksBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.UpdateTaskViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.UpdateTaskViewModelImpl

@AndroidEntryPoint
class UpdateTaskScreen : Fragment(R.layout.screen_updatetasks) {
    private val binding by viewBinding(ScreenUpdatetasksBinding::bind)
    private val viewModel: UpdateTaskViewModel by viewModels<UpdateTaskViewModelImpl>()
    private val args: UpdateTaskScreenArgs by navArgs()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        taskUpdateTittle.setText(args.task.title)
        updateTask.setOnClickListener {
            viewModel.updateTask(
                TaskData(
                    args.task.id,
                    title = taskUpdateTittle.text.toString(),
                    time = System.currentTimeMillis()
                )
            )
            viewModel.back()
        }
        viewModel.backLiveData.observe(this@UpdateTaskScreen, backObserver)
    }

    private val backObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}