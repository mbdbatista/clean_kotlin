package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category

@Component
class GetCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(id: Int): Category {
        return this.categoryRepository.findById(id) ?: throw NotFound("Category not found")
    }
}