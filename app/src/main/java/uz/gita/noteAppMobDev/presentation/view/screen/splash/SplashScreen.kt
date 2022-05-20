package uz.gita.noteAppMobDev.presentation.view.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.databinding.ScreenSplashBinding
import uz.gita.noteAppMobDev.presentation.viewmodel.splash.SplashViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.splash.impl.SplashViewModelImpl

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen:Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()
    private val binding by viewBinding(ScreenSplashBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this@SplashScreen, openMainScreenObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        image.animate().setDuration(200).scaleX(1f).scaleY(1f).setDuration(700).withEndAction {
            image.animate().scaleX(0f).scaleY(0f).duration = 500
            image.animate()
        }.start()
    }

    private val openMainScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_mainScreen)
    }
}