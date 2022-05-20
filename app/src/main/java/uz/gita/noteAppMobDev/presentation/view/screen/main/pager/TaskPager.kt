package uz.gita.noteAppMobDev.presentation.view.screen.main.pager

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.toTaskData
import uz.gita.noteAppMobDev.databinding.PagerTaskBinding
import uz.gita.noteAppMobDev.presentation.view.adapter.main.AddTaskAdapter
import uz.gita.noteAppMobDev.presentation.view.dialog.TaskDialog
import uz.gita.noteAppMobDev.presentation.view.screen.main.MainScreenDirections
import uz.gita.noteAppMobDev.presentation.viewmodel.main.TaskViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.TaskViewModelImpl

@AndroidEntryPoint
class TaskPager : Fragment(R.layout.pager_task) {
    private val viewModel: TaskViewModel by viewModels<TaskViewModelImpl>()
    private val binding by viewBinding(PagerTaskBinding::bind)
    private val taskAdapter = AddTaskAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        listTask.adapter = taskAdapter
        listTask.layoutManager = LinearLayoutManager(requireContext())

        taskAdapter.setOnItemClickListener {
            if (it.selected == 0) {
                viewModel.addChecked(it.id)
            } else {
                viewModel.deleteChecked(it.id)
            }
            viewModel.loadTask()
        }
        taskAdapter.setOnItemClickDialogListener { task ->
            val dialog = TaskDialog(task.toTaskData())
            dialog.setClickDeleteButtonListener {
                viewModel.deleteTask(it)
            }
            dialog.setClickEditButtonListener {
                findNavController().navigate(MainScreenDirections.actionMainScreenToUpdateTaskScreen(it))
            }
            dialog.show(childFragmentManager, "Note")
        }
        viewModel.tasksLiveData.observe(viewLifecycleOwner, tasksObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.loadTask()
    }

    private val tasksObserver = Observer<List<TaskEntity>> {
        taskAdapter.submitList(it)
    }

    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), "Error list", Toast.LENGTH_SHORT).show()
    }
}