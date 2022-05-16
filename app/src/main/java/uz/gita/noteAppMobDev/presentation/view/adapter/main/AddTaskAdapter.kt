package uz.gita.noteAppMobDev.presentation.view.adapter.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.sourse.local.entity.TaskEntity
import uz.gita.noteAppMobDev.databinding.TaskItemBinding
import java.text.SimpleDateFormat

class AddTaskAdapter : ListAdapter<TaskEntity, AddTaskAdapter.ViewHolder>(TaskDataDiffUtils) {

    private var onItemClickListener: ((TaskEntity) -> Unit)? = null
    private var onItemClickDialogListener: ((TaskEntity) -> Unit)? = null

    object TaskDataDiffUtils : DiffUtil.ItemCallback<TaskEntity>() {
        override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean =
            oldItem == newItem

    }

    inner class ViewHolder(private val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("  HH : mm")

        init {
            binding.taskCheck.setOnClickListener {
                onItemClickListener!!.invoke(getItem(absoluteAdapterPosition))
            }
            binding.root.setOnClickListener {
                onItemClickDialogListener!!.invoke(getItem(absoluteAdapterPosition))
            }
        }

        @SuppressLint("ResourceType")
        fun bind(): TaskEntity = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                val dateTime = simpleDateFormat.format(time)
                if (selected == 0) {
                    taskText.text = title
                    taskCheck.isChecked = false
                    taskTime.text = dateTime
                    taskText.setBackgroundResource(0)
                } else {
                    taskText.text = title
                    taskTime.text = dateTime
                    taskText.setBackgroundResource(R.drawable.strike)
                    taskCheck.isChecked = true
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        TaskItemBinding.bind(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.task_item, parent, false)
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnItemClickListener(block: (TaskEntity) -> Unit) {
        onItemClickListener = block
    }

    fun setOnItemClickDialogListener(block: (TaskEntity) -> Unit) {
        onItemClickDialogListener = block
    }
}