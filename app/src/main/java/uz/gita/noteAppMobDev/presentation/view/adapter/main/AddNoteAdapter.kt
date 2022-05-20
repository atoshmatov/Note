package uz.gita.noteAppMobDev.presentation.view.adapter.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.databinding.NoteItemBinding
import java.text.SimpleDateFormat

class AddNoteAdapter : ListAdapter<NoteEntity, AddNoteAdapter.ViewHolder>(NoteDataDiffUtils) {

    private var onItemClickListener: ((NoteEntity) -> Unit)? = null

    object NoteDataDiffUtils : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean =
            oldItem == newItem
    }

    inner class ViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("  HH : mm")

        init {
            binding.clicker.setOnClickListener {
                onItemClickListener!!.invoke(getItem(absoluteAdapterPosition))
            }
        }

        @SuppressLint("ResourceAsColor")
        fun bind(): NoteEntity = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                val dateTime = simpleDateFormat.format(time)
                noteText.text = title.trim()
                noteTime.text = dateTime
                descriptionNote.fromHtml(description.trim())
                descriptionNote.setTextColor(R.color.black)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        NoteItemBinding.bind(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.note_item, parent, false)
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnItemClickListener(block: (NoteEntity) -> Unit) {
        onItemClickListener = block
    }
}