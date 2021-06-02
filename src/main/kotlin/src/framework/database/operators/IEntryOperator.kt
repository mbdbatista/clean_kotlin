package src.framework.database.operators

import org.springframework.data.jpa.repository.JpaRepository
import src.framework.database.models.EntryEntity
import java.util.*

interface IEntryOperator: JpaRepository<EntryEntity, Int> {
    fun findByDateAfterAndDateBeforeAndSubCategoryEquals(startDate: Date?, endDate: Date?, subCategoryId: Int?): List<EntryEntity>
}