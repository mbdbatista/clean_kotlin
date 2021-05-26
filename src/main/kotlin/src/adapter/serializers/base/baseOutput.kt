package src.adapter.serializers.base

interface BaseOutput<T> {
    val data: T?
    val error: BaseError?
}

data class BaseError(val codigo: String, val message: String)