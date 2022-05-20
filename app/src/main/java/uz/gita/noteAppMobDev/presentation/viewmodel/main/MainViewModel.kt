package uz.gita.noteAppMobDev.presentation.viewmodel.main

import androidx.lifecycle.LiveData

interface MainViewModel {
    val openAboutLiveData: LiveData<Unit>

    fun openAbout()
}