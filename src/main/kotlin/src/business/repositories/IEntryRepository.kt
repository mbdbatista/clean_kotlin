package src.business.repositories

import src.domain.entities.Entry
import java.util.*

interface IEntryRepository {
    fun findById(id: Int): Entry?
    fun saveOrUpdate(entity: Entry): Entry
    fun list(startDate: Date?, endDate: Date?, subCategoryId: Int?): List<Entry>
    fun delete(id: Int): Boolean
}