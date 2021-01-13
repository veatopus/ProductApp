package kg.geektech.ruslan.feature_product.di

import kg.geektech.ruslan.feature_product.ui.basket.BasketProductViewModel
import kg.geektech.ruslan.feature_product.ui.favorite.FavoriteProductViewModel
import kg.geektech.ruslan.feature_product.ui.home.HomeProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureProductModule = module(override = true){
    viewModel { HomeProductViewModel(get(), get()) }
    viewModel { FavoriteProductViewModel(get(), get()) }
    viewModel { BasketProductViewModel(get(), get()) }
}