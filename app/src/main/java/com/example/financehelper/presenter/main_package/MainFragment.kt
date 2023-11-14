package com.example.financehelper.presenter.main_package

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentMainPageBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main_page) {

    private val binding: FragmentMainPageBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = MainScreenAdapter()

    private val viewModel: MainViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        super.onViewCreated(view, savedInstanceState)
        viewModel.walletNames.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.getWalletNames()
    }

    private fun initRecycler() = with(binding.walletRecycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@MainFragment.adapter
    }
}