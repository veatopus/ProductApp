package kg.geektech.ruslan.network.api

import kg.geektech.ruslan.exceptions.NoInternetConnection
import kg.geektech.ruslan.model.Product
import kg.geektech.ruslan.network.impl.ProductServiceApiImpl

interface ProductServiceApi {
    @Throws(NoInternetConnection::class)
    suspend fun fetchAllProduct() : MutableList<Product>

    companion object{
        fun build() : ProductServiceApi = ProductServiceApiImpl()
    }
}