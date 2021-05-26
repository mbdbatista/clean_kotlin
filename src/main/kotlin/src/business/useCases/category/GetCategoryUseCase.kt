package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.category.CategoryNotFound
import src.business.repositories.ICategoryRepository
import src.domain.types.CategoryType

@Component
class GetCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(id: Number): CategoryType {
        val category = this.categoryRepository.findById(id)
        if (category.isEmpty) {
            throw CategoryNotFound()
        }
        return category.get()
    }
}