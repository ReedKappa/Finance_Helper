package com.example.financehelper.presenter.main_package.main_fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.data.model.Finance
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.databinding.FragmentMainPageBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main_page) {

    private val binding: FragmentMainPageBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = MainScreenAdapter(::onAddClick, ::onShowClick)

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
        viewModel.totalSpent.observe(viewLifecycleOwner) {

        }
        viewModel.getWalletNames()
    }

    private fun initRecycler() = with(binding.walletRecycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@MainFragment.adapter
    }

    private fun onAddClick(wallet: Wallet) {
        val direction = MainFragmentDirections.actionMainFragmentToAddPurchaseFragment(wallet.walletId)
        findNavController().navigate(direction)
    }

    private fun onShowClick(wallet: Wallet) {
        val direction = MainFragmentDirections.actionMainFragmentToShowPurchasesFragment(wallet.walletId)
        findNavController().navigate(direction)
    }
}