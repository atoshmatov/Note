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
import org.wordpress.aztec.Aztec
import org.wordpress.aztec.ITextFormat
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.ScreenUpdatenotesBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.main.UpdateNoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.UpdateNoteViewModelImpl

@AndroidEntryPoint
class UpdateNoteScreen:Fragment(R.layout.screen_updatenotes) {
    private val binding by viewBinding(ScreenUpdatenotesBinding::bind)
    private val viewModel: UpdateNoteViewModel by viewModels<UpdateNoteViewModelImpl>()
    private val args: UpdateNoteScreenArgs by navArgs()

    @SuppressLint("ResourceAsColor", "FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val editor = editorNoteUpdate
        Aztec.with(editorNoteUpdate, linerUpdate, object : IAztecToolbarClickListener {
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

        editorNoteUpdate.fromHtml(args.note.description)
        tittleUpdate.setText(args.note.title)


        updateNote.setOnClickListener {
            viewModel.updateNote(
                NoteData(
                    args.note.id,
                    title = tittleUpdate.text.toString(),
                    description = editorNoteUpdate.toPlainHtml(),
                    time = System.currentTimeMillis(),
                )
            )
            viewModel.back()
        }
        viewModel.backLiveData.observe(this@UpdateNoteScreen, backObserver)
    }
    private val backObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}