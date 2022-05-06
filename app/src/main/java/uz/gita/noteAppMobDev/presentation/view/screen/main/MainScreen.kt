package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.databinding.ScreenMainBinding
import uz.gita.noteAppMobDev.presentation.view.adapter.MainAdapter
import uz.gita.noteAppMobDev.presentation.viewmodel.main.MainViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val mainAdapter by lazy { MainAdapter(childFragmentManager, lifecycle) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewPagerMain.adapter = mainAdapter
        TabLayoutMediator(tabLayout,viewPagerMain){ tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_sticky)
                else -> tab.setIcon(R.drawable.ic_check)
            }
        }.attach()
    }
}