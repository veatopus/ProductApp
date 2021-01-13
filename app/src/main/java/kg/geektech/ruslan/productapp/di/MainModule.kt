package kg.geektech.ruslan.productapp.di

import kg.geektech.ruslan.model.navigation.NavigationProvider
import kg.geektech.ruslan.productapp.navigation.NavigationProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val mainModule = module {
    single { NavigationProviderImpl(androidContext()) as NavigationProvider }
}