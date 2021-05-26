package src.domain.types

abstract class CategoryType {
    open var id: Int = 0
    open lateinit var name: String
}