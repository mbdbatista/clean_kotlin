package src.adapter.operators.entry

import org.springframework.stereotype.Component
import src.adapter.dto.EntryDto
import src.adapter.dto.toEntryDto
import src.business.useCases.entry.ListEntryUseCase
import java.util.*

@Component
class ListEntryOperator(private val listEntryUseCase: ListEntryUseCase) {
    fun run(startDate: Date?, endDate: Date?, subCategoryId: Int?): List<EntryDto> {
        val entry = this.listEntryUseCase.exec(startDate, endDate, subCategoryId)
        return entry.map { it.toEntryDto() }
    }
}