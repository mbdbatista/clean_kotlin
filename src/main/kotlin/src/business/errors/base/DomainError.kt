package src.business.errors.base

open class DomainError(val code: String, override val message: String): Error() {
}