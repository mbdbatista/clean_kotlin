package src.business.errors

data class NotFound(override val message: String): Exception(message)
