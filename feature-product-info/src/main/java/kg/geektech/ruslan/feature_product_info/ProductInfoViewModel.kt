package kg.geektech.ruslan.feature_product_info

import androidx.lifecycle.MutableLiveData
import kg.geektech.ruslan.core_utils.utils.BaseViewModel
import kg.geektech.ruslan.data.ProductRepository
import kg.geektech.ruslan.model.Product
import kg.geektech.ruslan.model.Status

class ProductInfoViewModel(private val repository: ProductRepository): BaseViewModel() {
    val product = MutableLiveData<Product>()

    fun getProductById(id: String) {
       repository.getById(id = id).observeForever{
           isLoading.value = it.status == Status.LOADING
           if (it.status == Status.SUCCESS && it.data != null) product.value = it.data!!
       }
    }

    fun shopClick(product: Product?) {
        product?.let {
            product.isChoice = !product.isChoice
            repository.insertProduct(product)
        }
    }

    fun favoriteClick(product: Product?) {
        product?.let {
            product.isFavourite = !product.isFavourite
            repository.insertProduct(product)
        }
    }

}