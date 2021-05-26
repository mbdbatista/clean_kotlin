package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.category.CategoryAlreadyRegistered
import src.business.repositories.ICategoryRepository
import src.domain.types.CategoryType

@Component
class CreateCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(name: String): CategoryType {
        val category = this.categoryRepository.findByName(name)
        if (category != null) {
            throw CategoryAlreadyRegistered()
        }
        return this.categoryRepository.create(name)
    }
}