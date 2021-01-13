package kg.geektech.ruslan.feature_product.ui.favorite

import kg.geektech.ruslan.data.ProductRepository
import kg.geektech.ruslan.feature_product.base_product_component.BaseProductViewModel
import kg.geektech.ruslan.model.Status
import kg.geektech.ruslan.model.navigation.NavigationProvider

class FavoriteProductViewModel(
    override val repository: ProductRepository,
    override val navigationProvider: NavigationProvider
) : BaseProductViewModel(repository, navigationProvider)  {

    override fun getProduct() {
        repository.getFavouriteProduct().observeForever {
            isLoading.value = it.status == Status.LOADING
            if (it.status == Status.SUCCESS && it.data != null) product.value = it.data!!
        }
    }
}