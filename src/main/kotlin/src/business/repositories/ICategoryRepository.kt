package src.business.repositories

import src.domain.entities.Category
import java.util.*

interface ICategoryRepository {
    fun findByName(name: String): Category?
    fun findById(id: Number): Optional<Category>
    fun create(name: String): Category
}