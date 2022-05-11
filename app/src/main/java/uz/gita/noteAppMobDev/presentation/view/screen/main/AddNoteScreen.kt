package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.richeditor.RichEditor
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.ScreenAddnoteBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.AddNoteViewModelImpl
import java.text.SimpleDateFormat


@AndroidEntryPoint
class AddNoteScreen : Fragment(uz.gita.noteAppMobDev.R.layout.screen_addnote) {
    private val binding by viewBinding(ScreenAddnoteBinding::bind)
    private val viewModel: AddNoteViewModel by viewModels<AddNoteViewModelImpl>()
    private lateinit var richEditor: RichEditor



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {

        richEditor = RichEditor(requireContext())
        richEditor.setPadding(10, 10, 10, 10)
        richEditor.setFontSize(18)
        richEditor.setPlaceholder("Insert text here...");
        addNote.setOnClickListener {
            viewModel.addNewNote(
                NoteData(
                    title = titleAdd.text.toString(),
                    description = editorNote.html,
                    time = System.currentTimeMillis(),
                )
            )
            findNavController().popBackStack()
        }
//        val textRich = editorNote.html as TextView
//        richEditor.setOnTextChangeListener {
//            textRich.text = it
//        }

        bold.setOnClickListener {
            richEditor.setBold()
        }
        italic.setOnClickListener {
            richEditor.setItalic()
        }
        strike.setOnClickListener {
            richEditor.setUnderline()
        }


    }
}