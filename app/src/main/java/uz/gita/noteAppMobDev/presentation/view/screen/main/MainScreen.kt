package uz.gita.noteAppMobDev.presentation.view.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppMobDev.R
import uz.gita.noteAppMobDev.databinding.ScreenMainBinding
import uz.gita.noteAppMobDev.presentation.view.adapter.main.MainAdapter
import uz.gita.noteAppMobDev.presentation.viewmodel.main.MainViewModel
import uz.gita.noteAppMobDev.presentation.viewmodel.main.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val mainAdapter by lazy { MainAdapter(childFragmentManager, lifecycle) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewPagerMain.adapter = mainAdapter
        viewPagerMain.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0) binding.pageName.setText(R.string.note)
                else binding.pageName.setText(R.string.task)
            }
        })
        TabLayoutMediator(tabLayout,viewPagerMain){ tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_sticky)
                }
                else -> {
                    tab.setIcon(R.drawable.ic_check)
                }
            }
        }.attach()

    }
}