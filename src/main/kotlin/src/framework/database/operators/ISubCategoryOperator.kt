package src.framework.database.operators

import org.springframework.data.jpa.repository.JpaRepository
import src.framework.database.models.SubCategoryEntity

interface ISubCategoryOperator: JpaRepository<SubCategoryEntity, Int> {
    fun findByName(name: String): SubCategoryEntity?
}