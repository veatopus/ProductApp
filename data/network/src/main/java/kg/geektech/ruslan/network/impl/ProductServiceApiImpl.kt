package kg.geektech.ruslan.network.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.geektech.ruslan.core_utils.utils.helpers.Utils
import kg.geektech.ruslan.exceptions.NoInternetConnection
import kg.geektech.ruslan.model.Product
import kg.geektech.ruslan.network.api.ProductServiceApi
import org.koin.java.KoinJavaComponent.inject

class ProductServiceApiImpl : ProductServiceApi {
    private val utils: Utils by inject(Utils::class.java)

    @Throws(NoInternetConnection::class)
    override suspend fun fetchAllProduct(): MutableList<Product> {
        val result: MutableList<Product> =
            Gson()
                .fromJson(
                    utils.getJsonFromAssets("MOCK_DATA.json"),
                    object : TypeToken<MutableList<Product>>() {}.type
                )
        if (result.isNullOrEmpty())
            throw NoInternetConnection()
        return result
    }

}