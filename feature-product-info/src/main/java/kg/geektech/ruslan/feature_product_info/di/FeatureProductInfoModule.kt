package kg.geektech.ruslan.feature_product_info.di

import kg.geektech.ruslan.feature_product_info.ProductInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureProductInfoModule = module {
    viewModel { ProductInfoViewModel(get()) }
}