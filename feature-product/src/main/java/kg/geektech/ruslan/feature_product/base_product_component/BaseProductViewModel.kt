package kg.geektech.ruslan.feature_product.base_product_component

import androidx.lifecycle.MutableLiveData
import kg.geektech.ruslan.core_utils.utils.BaseViewModel
import kg.geektech.ruslan.data.ProductRepository
import kg.geektech.ruslan.model.Product
import kg.geektech.ruslan.model.navigation.NavigationProvider

abstract class BaseProductViewModel(
    open val repository: ProductRepository,
    open val navigationProvider: NavigationProvider
) : BaseViewModel() {
    val product = MutableLiveData<MutableList<Product>>()

    abstract fun getProduct()

    fun onLikeClicked(model: Product) {
        repository.insertProduct(model)
    }

    fun openInfoFragment(id: String) {
        navigationProvider.provideFeatureNavigation().showFeatureProductInfo(id)
    }
}