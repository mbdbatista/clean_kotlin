package src.framework.repositories

import org.springframework.stereotype.Repository
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category
import src.framework.database.models.CategoryEntity
import src.framework.database.models.toCategory
import src.framework.database.models.toCategoryEntity
import src.framework.database.operators.ICategoryOperator

@Repository
class CategoryRepository(private val categoryDB: ICategoryOperator): ICategoryRepository {
    override fun findByName(name: String): Category? {
        return categoryDB.findByName(name)?.toCategory()
    }

    override fun findById(id: Number): Category? {
        val category = categoryDB.findById(id)
        if (category.isEmpty) {
            return null
        }
        return category.get().toCategory()
    }

    override fun create(name: String): Category {
        return categoryDB.save(CategoryEntity(name = name)).toCategory()
    }

    override fun findAllByName(name: String): List<Category> {
        return categoryDB.findAllByNameContainingOrNameIsNull(name).map { it.toCategory() }
    }

    override fun update(entity: Category): Category {
        val category = entity.toCategoryEntity()
        return categoryDB.save(category).toCategory()
    }

    override fun delete(id: Int): Boolean {
        categoryDB.deleteById(id)
        return true
    }

    override fun findAll(): List<Category> {
        return categoryDB.findAll().map { it.toCategory() }
    }
}