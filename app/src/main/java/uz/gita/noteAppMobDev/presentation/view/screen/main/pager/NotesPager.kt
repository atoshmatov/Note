package uz.gita.noteAppMobDev.presentation.view.screen.main.pager

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.NoteViewModelImpl

@AndroidEntryPoint
class NotesPager : Fragment(R.layout.pager_notes) {
    private val viewModel: NoteViewModel by viewModels<NoteViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<View>(R.id.addNote).setOnClickListener { viewModel.addNote(NoteData(title = "Title", description = "description", time = "05/05/2022")) }
        viewModel.notesLiveData.observe(viewLifecycleOwner) {
            Log.d("TTTR", "${it.size} ${it.firstOrNull()}")
        }

    }

}