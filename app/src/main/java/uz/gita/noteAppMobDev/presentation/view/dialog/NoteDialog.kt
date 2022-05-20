package uz.gita.noteAppMobDev.presentation.view.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.data.common.models.NoteData
import uz.gita.noteAppMobDev.databinding.NoteDialogItemBinding


class NoteDialog(private val noteData: NoteData) :
    DialogFragment(R.layout.note_dialog_item) {
    private val binding by viewBinding(NoteDialogItemBinding::bind)

    private var clickEditButtonListener: ((NoteData) -> Unit)? = null
    private var clickDeleteButtonListener: ((NoteData) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        view.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        delete.setOnClickListener {
            clickDeleteButtonListener?.invoke(noteData)
            dismiss()
        }
        edit.setOnClickListener {
            clickEditButtonListener?.invoke(noteData)
            dismiss()
        }
    }

    fun setClickEditButtonListener(block: (NoteData) -> Unit) {
        clickEditButtonListener = block
    }

    fun setClickDeleteButtonListener(block: (NoteData) -> Unit) {
        clickDeleteButtonListener = block
    }
}