package uz.gita.noteAppMobDev.presentation.view.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.databinding.AboutDialogItemBinding


class AboutDialog :
    DialogFragment(R.layout.about_dialog_item) {
    private val binding by viewBinding(AboutDialogItemBinding::bind)

    private var clickHomeButtonListener: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle2)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        view.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        home.setOnClickListener {
            dismiss()
            null
        }
        isCancelable = false
    }

    override fun onDestroy() {
        super.onDestroy()
        dismiss()
    }
}