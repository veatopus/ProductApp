package kg.geektech.ruslan.data.di

import kg.geektech.ruslan.data.ProductRepository
import kg.geektech.ruslan.data.provideCoroutineContext
import kg.geektech.ruslan.data.provideJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module(override = true) {
    factory { provideCoroutineContext(get()) }
    factory { provideJob() }
    single { ProductRepository(get(), get(), androidContext(), get()) }
}