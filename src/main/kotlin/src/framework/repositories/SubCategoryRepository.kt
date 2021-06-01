package src.framework.repositories

import org.springframework.stereotype.Repository
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory
import src.framework.database.models.SubCategoryEntity
import src.framework.database.models.toSubCategory
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

    override fun findByName(name: String): SubCategory? {
        return this.subCategoryDB.findByName(name)?.toSubCategory()
    }

    override fun create(name: String, category: Int): SubCategory {
        val entity = SubCategoryEntity(name = name, category = category)
        return this.subCategoryDB.save(entity).toSubCategory()
    }
}