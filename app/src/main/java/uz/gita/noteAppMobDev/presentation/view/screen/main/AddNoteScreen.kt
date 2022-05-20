package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.wordpress.aztec.Aztec
import org.wordpress.aztec.ITextFormat
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.ScreenAddnoteBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.AddNoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.AddNoteViewModelImpl


@AndroidEntryPoint
class AddNoteScreen : Fragment(uz.gita.noteAppMobDev.R.layout.screen_addnote) {
    private val binding by viewBinding(ScreenAddnoteBinding::bind)
    private val viewModel: AddNoteViewModel by viewModels<AddNoteViewModelImpl>()

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val editor = editorNote
        Aztec.with(editorNote, liner, object : IAztecToolbarClickListener {
            override fun onToolbarCollapseButtonClicked() {}

            override fun onToolbarExpandButtonClicked() {}

            override fun onToolbarFormatButtonClicked(
                format: ITextFormat,
                isKeyboardShortcut: Boolean
            ) {
            }

            override fun onToolbarHeadingButtonClicked() {}

            override fun onToolbarHtmlButtonClicked() {}

            override fun onToolbarListButtonClicked() {}

            override fun onToolbarMediaButtonClicked(): Boolean = false

        })
        editor.setBackgroundResource(R.drawable.search_style)
        editor.gravity = View.TEXT_ALIGNMENT_TEXT_START
        editor.setTextColor(R.color.black)
        editor.highlightColor = R.color.black
        addNote.setOnClickListener {
            viewModel.addNewNote(
                NoteData(
                    title = titleAdd.text.toString().trim(),
                    description = editorNote.toPlainHtml().trim(),
                    time = System.currentTimeMillis(),
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