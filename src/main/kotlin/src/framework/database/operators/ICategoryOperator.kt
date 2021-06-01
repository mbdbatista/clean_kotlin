package src.framework.database.operators

import org.springframework.data.jpa.repository.JpaRepository
import src.framework.database.models.CategoryEntity

interface ICategoryOperator: JpaRepository<CategoryEntity, Number> {
    fun findByName(name: String): CategoryEntity?
    fun findAllByNameContainingOrNameIsNull(name: String): List<CategoryEntity>
}