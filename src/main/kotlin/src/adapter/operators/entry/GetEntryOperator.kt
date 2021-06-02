package src.adapter.operators.entry

import org.springframework.stereotype.Component
import src.adapter.dto.EntryDto
import src.adapter.dto.toEntryDto
import src.business.useCases.entry.GetEntryUseCase

@Component
class GetEntryOperator(private val getEntryUseCase: GetEntryUseCase) {
    fun run(id: Int): EntryDto {
        val entry = this.getEntryUseCase.exec(id)
        return entry.toEntryDto()
    }
}