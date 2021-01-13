package kg.geektech.ruslan.exceptions

abstract class AppException(
    message: String? = null,
    exception: Throwable? = null
) : Throwable(message = message, cause = exception) {
    abstract fun getMessageTask() : String
}