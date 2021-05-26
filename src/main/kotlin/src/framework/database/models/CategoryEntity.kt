package src.framework.database.models

import src.domain.entities.Category
import src.domain.types.CategoryType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity(name = "Category")
class CategoryEntity() : CategoryType() {

    constructor(name: String): this() {
        this.name = name
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int = 0
    override lateinit var name: String

    fun toCategory(): Category {
        return Category(this.id, this.name)
    }
}