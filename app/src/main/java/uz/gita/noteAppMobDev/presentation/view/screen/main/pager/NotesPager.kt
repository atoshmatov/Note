package uz.gita.noteAppMobDev.presentation.view.screen.main.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.data.sourse.local.entity.toData
import uz.gita.noteAppMobDev.databinding.PagerNotesBinding
import uz.gita.noteAppMobDev.presentation.view.adapter.main.AddNoteAdapter
import uz.gita.noteAppMobDev.presentation.view.dialog.NoteDialog
import uz.gita.noteAppMobDev.presentation.view.screen.main.MainScreenDirections
import uz.gita.noteAppMobDev.presentation.viewmodel.main.NoteViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.NoteViewModelImpl

@AndroidEntryPoint
class NotesPager : Fragment(R.layout.pager_notes) {
    private val viewModel: NoteViewModel by viewModels<NoteViewModelImpl>()
    private val binding by viewBinding(PagerNotesBinding::bind)
    private val noteAdapter = AddNoteAdapter()
//    private var sendNoteDataUpdate: ((NoteData) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        listNote.adapter = noteAdapter
        listNote.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        noteAdapter.setOnItemClickListener { note ->
            val dialog = NoteDialog(note.toData())
            dialog.setClickDeleteButtonListener {
                viewModel.deleteNote(it)
            }
            dialog.setClickEditButtonListener {
                findNavController().navigate(
                    MainScreenDirections.actionMainScreenToUpdateNoteScreen(
                        it
                    )
                )
            }
            dialog.show(childFragmentManager, "Note")
        }
        viewModel.notesLiveData.observe(viewLifecycleOwner, notesObserver)
        viewModel.loadNotes()
        viewModel.pleaseHolderLiveData.observe(viewLifecycleOwner, pleaseHolderObserver)
    }


    private val pleaseHolderObserver = Observer<Boolean> {
        if (it) {
            binding.imageEmpty.visibility = View.VISIBLE
        } else binding.imageEmpty.visibility = View.GONE
    }
    private val notesObserver = Observer<List<NoteEntity>> {
        noteAdapter.submitList(it)
    }
}