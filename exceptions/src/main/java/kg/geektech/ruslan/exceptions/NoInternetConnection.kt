package kg.geektech.ruslan.exceptions

class NoInternetConnection : AppException() {
    override fun getMessageTask(): String = "no internet connection"
}