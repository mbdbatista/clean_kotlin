package src.business.errors

data class AlreadyRegistered(override val message: String): Exception(message)