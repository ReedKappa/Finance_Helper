package com.example.financehelper.presenter.main_package.show_purchase_fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentSeePurchasesBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import com.example.financehelper.presenter.main_package.add_purchase_fragment.AddPurchaseFragmentArgs
import com.example.financehelper.presenter.main_package.add_purchase_fragment.AddPurchaseViewModel
import javax.inject.Inject

class ShowPurchasesFragment: Fragment(R.layout.fragment_see_purchases) {

    private val args: ShowPurchasesFragmentArgs by navArgs()

    private val binding: FragmentSeePurchasesBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = ShowPurchasesAdapter()

    private val viewModel: ShowPurchasesViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.purchasesRecycler) {
            adapter = this@ShowPurchasesFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.purchases.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.getPurchasesOrdered(args.walletId)
    }

    private fun initRecycler() = with(binding.purchasesRecycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@ShowPurchasesFragment.adapter
    }
}