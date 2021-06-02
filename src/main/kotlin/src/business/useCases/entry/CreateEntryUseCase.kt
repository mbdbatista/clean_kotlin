package src.business.useCases.entry

import org.springframework.stereotype.Component
import src.business.repositories.IEntryRepository
import src.domain.entities.Entry
import java.util.*

@Component
class CreateEntryUseCase(private val entryRepository: IEntryRepository) {
    fun exec(value: Double, date: Date,subCategory: Int?,comment: String?): Entry {
        val entity = Entry(value = value, date = date, subCategory = subCategory, comment = comment)
        return this.entryRepository.saveOrUpdate(entity)
    }
}