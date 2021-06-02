package src.business.useCases.entry

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import src.domain.entities.SubCategory
import java.util.*

@Component
class ListEntryUseCase(private val entryRepository: IEntryRepository) {
    fun exec(startDate: Date?, endDate: Date?, subCategoryId: Int?): List<Entry> {
        return this.entryRepository.list(startDate, endDate, subCategoryId)
    }
}