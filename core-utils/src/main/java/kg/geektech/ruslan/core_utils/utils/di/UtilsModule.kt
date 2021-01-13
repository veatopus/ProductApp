package kg.geektech.ruslan.core_utils.utils.di

import kg.geektech.ruslan.core_utils.utils.helpers.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {
    factory { Utils(androidContext()) }
}