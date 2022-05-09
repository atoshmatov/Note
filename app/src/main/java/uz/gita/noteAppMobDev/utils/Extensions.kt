package uz.gita.noteAppMobDev.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import uz.gita.noteAppMobDev.R

fun View.onClick(action: (View?) -> Unit) {
    setOnClickListener {
        it?.let { action(it) }
    }
}

fun AppCompatEditText.textToString(): String {
    return this.text.toString()
}

fun Fragment.snackMessage(message: String) {
    Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).apply {
        setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.yellow))
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }.show()
}

fun Fragment.snackErrorMessage(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(requireView(), message, duration).apply {
        setBackgroundTint(ContextCompat.getColor(requireContext(), android.R.color.holo_red_light))
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }.show()
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
