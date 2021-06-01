package src.business.repositories

import src.domain.entities.Category
import java.util.*

interface ICategoryRepository {
    fun findByName(name: String): Category?
    fun findById(id: Number): Category?
    fun create(name: String): Category
    fun findAllByName(name: String): List<Category>
    fun update(entity: Category): Category
    fun delete(id: Int): Boolean
    fun findAll(): List<Category>
}