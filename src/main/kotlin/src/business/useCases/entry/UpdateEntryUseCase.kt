package src.business.useCases.entry

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import java.util.*

@Component
class UpdateEntryUseCase(private val entryRepository: IEntryRepository) {
    fun exec(id: Int, value: Double, date: Date, subCategory: Int?, comment: String?): Entry {
        this.entryRepository.findById(id) ?: throw NotFound("Entry not found")
        val entry = Entry(id, value, date, subCategory, comment)
        return this.entryRepository.saveOrUpdate(entry)
    }
}