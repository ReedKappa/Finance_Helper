package com.example.financehelper.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.financehelper.presenter.main_package.add_purchase_fragment.AddPurchaseViewModel
import com.example.financehelper.presenter.main_package.main_fragment.MainViewModel
import com.example.financehelper.presenter.main_package.show_purchase_fragment.ShowPurchasesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AddPurchaseViewModel::class)
    fun bindAddPurchaseViewModel(viewModel: AddPurchaseViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowPurchasesViewModel::class)
    fun bindShowPurchaseViewModel(viewModel: ShowPurchasesViewModel) : ViewModel

}