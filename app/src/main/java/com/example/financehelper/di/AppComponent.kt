package com.example.financehelper.di

import android.app.Application
import com.example.financehelper.FinanceHelperApplication
import com.example.financehelper.presenter.main_package.add_purchase_fragment.AddPurchaseFragment
import com.example.financehelper.presenter.main_package.main_fragment.MainFragment
import com.example.financehelper.presenter.main_package.show_purchase_fragment.ShowPurchasesFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
    ]
)
@Singleton
interface AppComponent {
    fun inject(fragment: MainFragment)
    fun inject(fragment: AddPurchaseFragment)
    fun inject(fragment: ShowPurchasesFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}


@Module(
    includes = [
        ViewModelModule::class,
        AppBindsModule::class,
        DataBaseModule::class,
    ]
)
class AppModule