package kg.geektech.ruslan.network.di

import kg.geektech.ruslan.network.api.ProductServiceApi
import org.koin.dsl.module

val networkModule = module {
     factory { ProductServiceApi.build() }
}