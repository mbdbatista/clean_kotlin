package src.adapter.operators.entry

import org.springframework.stereotype.Component
import src.adapter.dto.EntryDto
import src.adapter.dto.toEntryDto
import src.business.useCases.entry.CreateEntryUseCase

@Component
class CreateEntryOperator(private val createEntryUseCase: CreateEntryUseCase) {
    fun run(input: EntryDto): EntryDto {
        val entry = this.createEntryUseCase.exec(value = input.value, date = input.date, subCategory = input.subCategory, comment = input.comment)
        return entry.toEntryDto()
    }
}