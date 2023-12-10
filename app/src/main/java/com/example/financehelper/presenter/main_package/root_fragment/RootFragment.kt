package com.example.financehelper.presenter.main_package.root_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financehelper.MainActivity
import com.example.financehelper.R
import com.example.financehelper.databinding.FragmentRootBinding
import com.example.financehelper.di.ViewModelFactory
import com.example.financehelper.di.appComponent
import javax.inject.Inject

class RootFragment: Fragment(R.layout.fragment_root) {
    private val binding: FragmentRootBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: RootViewModel by viewModels {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isRequired.observe(viewLifecycleOwner) {
            val navHostFragment = childFragmentManager.findFragmentById(R.id.root_fragment_id) as NavHostFragment
            val inflater = navHostFragment.navController.navInflater
            val graph: NavGraph = inflater.inflate(R.navigation.navigation)
            Log.d("ONBOARDING", it.toString())
            if (it) {
                graph.setStartDestination(R.id.addSalaryFragment)
            } else {
                graph.setStartDestination(R.id.mainFragment)
            }

            val navController = navHostFragment.navController
            navController.graph = graph

            if (requireActivity() is MainActivity) {
                (requireActivity() as MainActivity).onPressedBack = {
                    navController.popBackStack()
                }
            }


        }
    }
}