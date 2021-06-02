package src.business.useCases.balance

import org.springframework.stereotype.Component
import src.business.repositories.ICategoryRepository
import src.business.repositories.IEntryRepository
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.Balance
import java.util.*

@Component
class GetBalanceUseCase(
    val entryRepository: IEntryRepository,
    val subCategoryRepository: ISubCategoryRepository,
    val categoryRepository: ICategoryRepository
) {
    fun exec(startDate: Date, endDate: Date, categoryId: Int?): Balance {
        var category = categoryRepository.findById(categoryId ?: 0)
        var entries = this.entryRepository.list(startDate, endDate, null)
        if (categoryId != null) {
            var subCategories = subCategoryRepository.findAllById(entries.map { it.subCategory!! })
            val subIds = subCategories.filter { it.category == categoryId }.map { it.id }
            entries = entries.filter {
                subIds.contains(it.subCategory)
            }
        }

        val revenue = entries
            .asSequence()
            .filter {
                it.value >= 0
            }.sumByDouble {
                it.value
            }

        val disbursement = entries
            .asSequence()
            .filter {
                it.value < 0
            }.sumByDouble {
                it.value
            }

        val balance = (revenue - (disbursement * -1))
        return Balance(category = category, revenue, disbursement, balance)
    }
}