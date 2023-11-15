package com.example.financehelper.presenter.main_package.add_purchase_fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentAddPurchaseBinding
import com.example.financehelper.databinding.FragmentMainPageBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import com.example.financehelper.presenter.main_package.main_fragment.MainScreenAdapter
import com.example.financehelper.presenter.main_package.main_fragment.MainViewModel
import javax.inject.Inject

class AddPurchaseFragment: Fragment(R.layout.fragment_add_purchase) {

    private val args: AddPurchaseFragmentArgs by navArgs()

    private val binding: FragmentAddPurchaseBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: AddPurchaseViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.success.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Ошибка при добавлении покупки", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonConfirm.setOnClickListener {
            viewModel.addPurchase(args.walletId, binding.inputPurchaseName.text.toString(), binding.inputPurchaseCost.text.toString().toDouble())

        }
    }
}