package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.richeditor.RichEditor
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.ScreenAddnoteBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.AddNoteViewModelImpl

@AndroidEntryPoint
class AddNoteScreen : Fragment(R.layout.screen_addnote) {
    private val binding by viewBinding(ScreenAddnoteBinding::bind)
    private val viewModel: AddNoteViewModel by viewModels<AddNoteViewModelImpl>()
    private lateinit var richEditor: RichEditor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        addNote.setOnClickListener {
            viewModel.addNewNote(
                NoteData(
                    title = titleAdd.text.toString(),
                    description = editorNote.html,
                    time = 12L,
                )
            )
            Log.d("addNote", "${titleAdd.text.toString()} ${editorNote.toString()}")
            findNavController().popBackStack()
        }
    }
}