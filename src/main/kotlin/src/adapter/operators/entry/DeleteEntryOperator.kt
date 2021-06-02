package src.adapter.operators.entry

import org.springframework.stereotype.Component
import src.business.useCases.entry.DeleteEntryUseCase

@Component
class DeleteEntryOperator(private val deleteEntryUseCase: DeleteEntryUseCase) {
    fun run(id: Int): Boolean {
        return this.deleteEntryUseCase.exec(id)
    }
}