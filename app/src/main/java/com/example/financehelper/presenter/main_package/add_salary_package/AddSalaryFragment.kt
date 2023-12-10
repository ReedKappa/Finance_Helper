package com.example.financehelper.presenter.main_package.add_salary_package

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentAddSalaryBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import javax.inject.Inject

class AddSalaryFragment: Fragment(R.layout.fragment_add_salary) {
    private val binding: FragmentAddSalaryBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: AddSalaryViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonDone.setOnClickListener {
            viewModel.upsertSalary(binding.salaryInput.text.toString().toDouble()) {
                findNavController().popBackStack()
            }
        }
    }
}