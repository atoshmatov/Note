package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.richeditor.RichEditor
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.ScreenAddnoteBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.AddNoteViewModelImpl
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddNoteScreen : Fragment(R.layout.screen_addnote) {
    private val binding by viewBinding(ScreenAddnoteBinding::bind)
    private val viewModel: AddNoteViewModel by viewModels<AddNoteViewModelImpl>()
    private lateinit var richEditor: RichEditor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        @SuppressLint("SimpleDateFormat")
        val df: DateFormat = SimpleDateFormat("h:mm a")
        val date: String = df.format(Calendar.getInstance().time)


        addNote.setOnClickListener {
            viewModel.addNewNote(
                NoteData(
                    title = titleAdd.text.toString(),
                    description = editorNote.toString(),
                    time = date.toString(),
                )
            )
        }
    }
}