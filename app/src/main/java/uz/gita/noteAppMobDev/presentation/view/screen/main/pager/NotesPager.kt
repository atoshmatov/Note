package uz.gita.noteAppMobDev.presentation.view.screen.main.pager

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.toData
import uz.gita.noteAppMobDev.databinding.PagerNotesBinding
import uz.gita.noteAppMobDev.presentation.view.adapter.main.AddNoteAdapter
import uz.gita.noteAppMobDev.presentation.view.dialog.NoteDialog
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.NoteViewModelImpl

@AndroidEntryPoint
class NotesPager : Fragment(R.layout.pager_notes) {
    private val viewModel: NoteViewModel by viewModels<NoteViewModelImpl>()
    private val binding by viewBinding(PagerNotesBinding::bind)
    private val noteAdapter = AddNoteAdapter()
    private var sendNoteDataUpdate: ((NoteData) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        listNote.adapter = noteAdapter
        listNote.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        noteAdapter.setOnItemClickListener { note ->
            val dialog = NoteDialog(note.toData())
            dialog.setClickDeleteButtonListener {
                viewModel.deleteNote(it)
            }
            dialog.setClickEditButtonListener {
                sendNoteDataUpdate!!.invoke(it)
            }
            dialog.show(childFragmentManager, "Note")
        }
        viewModel.notesLiveData.observe(viewLifecycleOwner, notesObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.loadNotes()
    }

    private val notesObserver = Observer<List<NoteEntity>> {
        noteAdapter.submitList(it)
    }
    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), "Error list", Toast.LENGTH_SHORT).show()
    }

    fun setSendNoteDataUpdate(block: (NoteData) -> Unit) {
        sendNoteDataUpdate = block
    }
}