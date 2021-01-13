package kg.geektech.ruslan.data

import android.content.Context
import androidx.lifecycle.liveData
import kg.geektech.ruslan.core_utils.utils.helpers.showToast
import kg.geektech.ruslan.exceptions.NoInternetConnection
import kg.geektech.ruslan.exceptions.NotFoundException
import kg.geektech.ruslan.local.dao.ProductDao
import kg.geektech.ruslan.model.Product
import kg.geektech.ruslan.model.Resource
import kg.geektech.ruslan.network.api.ProductServiceApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProductRepository(
    private val api: ProductServiceApi,
    private val dao: ProductDao,
    private val context: Context,
    override val coroutineContext: CoroutineContext
) : CoroutineScope{

    fun getProduct() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            api.fetchAllProduct().forEach { dao.insertWithIgnore(it) }
            emit(Resource.success(dao.getAll()))
        } catch (ex: NoInternetConnection) {
            context.showToast(ex.getMessageTask())
            emit(Resource.error(data = null, message = ex.getMessageTask()))
        } catch (e: Exception){
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }

    fun getById(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(dao.getById(id) ?: throw NotFoundException()))
        } catch (e: java.lang.Exception){
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }

    fun getFavouriteProduct() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(dao.getFavouriteProduct() ?: throw NotFoundException()))
        } catch (e: java.lang.Exception){
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }

    fun getChoiceProduct() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(dao.getChoiceProduct() ?: throw NotFoundException()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }

    fun insertProduct(product: Product){
        launch {
            dao.insertWithReplace(product)
        }
    }

}