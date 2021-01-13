package kg.geektech.ruslan.core_utils.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val toast = MutableLiveData<String>()
    val isFinished = MutableLiveData(false)
    val isLoading = MutableLiveData(false)

}