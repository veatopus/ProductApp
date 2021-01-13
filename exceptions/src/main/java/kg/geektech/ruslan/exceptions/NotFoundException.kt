package kg.geektech.ruslan.exceptions

class NotFoundException : AppException() {
    override fun getMessageTask(): String = "file not found"
}