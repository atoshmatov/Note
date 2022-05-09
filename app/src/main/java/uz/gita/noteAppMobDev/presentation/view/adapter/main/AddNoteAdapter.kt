package uz.gita.noteAppMobDev.presentation.view.adapter.main

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.NoteItemBinding

class AddNoteAdapter : ListAdapter<NoteData, AddNoteAdapter.ViewHolder>(NoteDataDiffUtils) {

    private var onItemClickListener: ((NoteData) -> Unit)? = null

    object NoteDataDiffUtils : DiffUtil.ItemCallback<NoteData>() {
        override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean =
            oldItem == newItem

    }

    inner class ViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClickListener!!.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind(): NoteData = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                noteText.text = title
                noteTime.text = time
                descriptionNote.text = Html.fromHtml(description)
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

    fun setOnItemClickListener(block: (NoteData) -> Unit) {
        onItemClickListener = block
    }
}