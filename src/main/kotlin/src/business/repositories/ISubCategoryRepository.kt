package src.business.repositories

import src.domain.entities.SubCategory

interface ISubCategoryRepository {
    fun findById(id: Int): SubCategory?
    fun findAllById(ids: List<Int>): List<SubCategory>
    fun findByName(name: String): SubCategory?
    fun create(name: String, category: Int): SubCategory
    fun update(entity: SubCategory): SubCategory
    fun list(name: String?, id:Int?): List<SubCategory>
    fun findAll(): List<SubCategory>
    fun delete(id: Int): Boolean
}