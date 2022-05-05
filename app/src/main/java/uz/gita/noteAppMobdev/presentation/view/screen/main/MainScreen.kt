package uz.gita.noteAppMobdev.presentation.view.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobdev.R
import uz.gita.noteAppMobdev.databinding.ScreenMainBinding
import uz.gita.noteAppMobdev.presentation.view.adapter.MainAdapter
import uz.gita.noteAppMobdev.presentation.viewmodel.main.MainViewModel
import uz.gita.noteAppMobdev.presentation.viewmodel.main.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val mainAdapter by lazy { MainAdapter(childFragmentManager, lifecycle) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewPagerMain.adapter = mainAdapter
        TabLayoutMediator(tabLayout,viewPagerMain){tab,position->
            when(position){
                0 ->{
                    tab.text = "Notes"
                }
                else ->{
                    tab.text = "Task"
                }
            }
        }.attach()
    }
}