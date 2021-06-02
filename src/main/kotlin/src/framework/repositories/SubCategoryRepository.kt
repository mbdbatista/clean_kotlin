package src.framework.repositories

import org.springframework.stereotype.Repository
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory
import src.framework.database.models.SubCategoryEntity
import src.framework.database.models.toCategoryEntity
import src.framework.database.models.toSubCategory
import src.framework.database.models.toSubCategoryEntity
import src.framework.database.operators.ISubCategoryOperator

@Repository
class SubCategoryRepository(
    private val subCategoryDB: ISubCategoryOperator
): ISubCategoryRepository {
    override fun findById(id: Int): SubCategory? {
        val subCategory = this.subCategoryDB.findById(id)
        if (subCategory.isEmpty) {
            return null
        }
        return subCategory.get().toSubCategory()
    }

    override fun findAllById(ids: List<Int>): List<SubCategory> {
        return this.subCategoryDB.findAllById(ids).map { it.toSubCategory() }
    }

    override fun findByName(name: String): SubCategory? {
        return this.subCategoryDB.findByName(name)?.toSubCategory()
    }

    override fun create(name: String, category: Int): SubCategory {
        val entity = SubCategoryEntity(name = name, category = category)
        return this.subCategoryDB.save(entity).toSubCategory()
    }

    override fun update(entity: SubCategory): SubCategory {
        val subCategory = entity.toSubCategoryEntity()
        return this.subCategoryDB.save(subCategory).toSubCategory()
    }

    override fun list(name: String?, id: Int?): List<SubCategory> {
        return this.subCategoryDB.findByNameOrIdOrNameIsNullOrIdIsNull(name, id).map { it.toSubCategory() }
    }

    override fun findAll(): List<SubCategory> {
        return this.subCategoryDB.findAll().map { it.toSubCategory() }
    }

    override fun delete(id: Int): Boolean {
        this.subCategoryDB.deleteById(id)
        return true
    }
}