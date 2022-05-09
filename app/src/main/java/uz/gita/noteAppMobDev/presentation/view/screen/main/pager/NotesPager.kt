package uz.gita.noteAppMobDev.presentation.view.screen.main.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.NoteViewModelImpl

@AndroidEntryPoint
class NotesPager : Fragment(R.layout.pager_notes) {
    private val viewModel: NoteViewModel by viewModels<NoteViewModelImpl>()

}