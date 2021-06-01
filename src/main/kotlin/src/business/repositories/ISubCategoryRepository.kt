package src.business.repositories

import src.domain.entities.SubCategory

interface ISubCategoryRepository {
    fun findById(id: Int): SubCategory?
    fun findByName(name: String): SubCategory?
    fun create(name: String, category: Int): SubCategory
}