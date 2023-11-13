package com.example.financehelper.di

import com.example.financehelper.presenter.main_package.MainFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: MainFragment)
}


@Module(
    includes = [
        ViewModelModule::class,
        AppBindsModule::class
    ]
)
class AppModule {

}