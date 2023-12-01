package com.example.financehelper.di

import com.example.financehelper.presenter.main_package.add_purchase_fragment.AddPurchaseFragment
import com.example.financehelper.presenter.main_package.main_fragment.MainFragment
import com.example.financehelper.presenter.main_package.show_purchase_fragment.ShowPurchasesFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: MainFragment)
    fun inject(fragment: AddPurchaseFragment)
    fun inject(fragment: ShowPurchasesFragment)
}


@Module(
    includes = [
        ViewModelModule::class,
        AppBindsModule::class
    ]
)
class AppModule {

}