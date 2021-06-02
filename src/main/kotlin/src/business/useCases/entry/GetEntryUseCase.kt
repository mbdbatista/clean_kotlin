package src.business.useCases.entry

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import java.util.*

@Component
class GetEntryUseCase(private val entryRepository: IEntryRepository) {
    fun exec(id: Int): Entry {
        return this.entryRepository.findById(id) ?: throw NotFound("Entry not found")
    }
}