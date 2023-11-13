package com.example.financehelper.presenter.main_package

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentMainPageBinding
import com.example.financehelper.di.ViewModelFactory

class MainFragment: Fragment(R.layout.fragment_main_page) {

    private val binding: FragmentMainPageBinding by viewBinding()

    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = MainScreenAdapter()


}