package src.framework.repositories

import org.springframework.stereotype.Repository
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category
import src.framework.database.models.CategoryEntity
import src.framework.database.operators.ICategoryOperator
import java.util.*

@Repository
class CategoryRepository(private val categoryDB: ICategoryOperator): ICategoryRepository {
    override fun findByName(name: String): Category? {
        return categoryDB.findByName(name)?.toCategory()
    }

    override fun findById(id: Number): Optional<Category> {
        return categoryDB.findById(id).map { it.toCategory() }
    }

    override fun create(name: String): Category {
        return categoryDB.save(CategoryEntity(name = name)).toCategory()
    }
}