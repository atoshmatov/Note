package uz.gita.noteAppMobDev.presentation.viewmodel.main.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.noteAppMobDev.domain.usecase.MainUseCase
import uz.gita.noteAppMobDev.presentation.viewmodel.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor( private val useCase: MainUseCase) : ViewModel(), MainViewModel {
}