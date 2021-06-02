package src.adapter.operators.entry

import org.springframework.stereotype.Component
import src.adapter.dto.EntryDto
import src.adapter.dto.toEntryDto
import src.business.useCases.entry.UpdateEntryUseCase

@Component
class UpdateEntryOperator(private val updateEntryUseCase: UpdateEntryUseCase) {
    fun run(input: EntryDto): EntryDto {
        val entry = this.updateEntryUseCase.exec(input.id, input.value, input.date, input.subCategory, input.comment)
        return entry.toEntryDto()
    }
}