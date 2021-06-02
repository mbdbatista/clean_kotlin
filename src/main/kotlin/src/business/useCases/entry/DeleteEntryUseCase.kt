package src.business.useCases.entry

import org.springframework.stereotype.Component
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import java.util.*

@Component
class DeleteEntryUseCase(private val entryRepository: IEntryRepository) {
    fun exec(id: Int): Boolean {
        this.entryRepository.delete(id)
        return true
    }
}