package com.example.financehelper.presenter.main_package.main_fragment

import android.app.AlertDialog
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        viewModel.financeList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            for (wallet in it.drop(1)) {
                if ((wallet as Wallet).moneyLeft <=0) {
                    MaterialAlertDialogBuilder(requireContext()).setTitle("Внимание!")
                        .setMessage("Внимание, вы потратили все доступные средства в ${wallet.walletName} " +
                                "пожалуйста воздержитесь от затрат на данную категорию!")
                        .setNeutralButton("Ок") {_,_ ->
                        }
                        .create()
                        .show()
                }
            }
        }
        binding.salaryResetButton.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext()).setTitle("Подтвердите действие")
                .setMessage("Внимание! При подтверждении данного действия все данные будут удалены!" +
                        "Вы действительно хотите утратить весь прогресс?")
                .setPositiveButton("Подтвердить") {_,_ ->
                    viewModel.resetProgress()
                }
                .setNeutralButton("Отмена") {_,_ ->
                }
                .create()
                .show()

        }

        viewModel.getSalaryAndWallets()
    }

    private fun initRecycler() = with(binding.walletRecycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@MainFragment.adapter
    }

    private fun onAddClick(wallet: Wallet) {
        val direction = MainFragmentDirections.actionMainFragmentToAddPurchaseFragment(wallet.id)
        findNavController().navigate(direction)
    }

    private fun onShowClick(wallet: Wallet) {
        val direction = MainFragmentDirections.actionMainFragmentToShowPurchasesFragment(wallet.id)
        findNavController().navigate(direction)
    }
}