package src.framework.repositories

import org.springframework.stereotype.Repository
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import src.framework.database.models.toEntry
import src.framework.database.models.toEntryEntity
import src.framework.database.operators.IEntryOperator
import java.util.*

@Repository
class EntryRepository(
    private val entryDB: IEntryOperator
): IEntryRepository {
    override fun findById(id: Int): Entry? {
        val entity = entryDB.findById(id)
        if (entity.isEmpty) {
            return null
        }
        return entity.get().toEntry()
    }

    override fun saveOrUpdate(entity: Entry): Entry {
        val entry = entity.toEntryEntity()
        return this.entryDB.save(entry).toEntry()
    }

    override fun list(startDate: Date?, endDate: Date?, subCategoryId: Int?): List<Entry> {
        return this.entryDB.findByDateAfterAndDateBeforeAndSubCategoryEquals(startDate, endDate, subCategoryId).map { it.toEntry() }
    }

    override fun delete(id: Int): Boolean {
        this.entryDB.deleteById(id)
        return true
    }
}