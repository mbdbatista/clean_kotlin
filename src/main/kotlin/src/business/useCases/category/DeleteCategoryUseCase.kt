package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.ICategoryRepository

@Component
class DeleteCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(id: Int): Boolean {
        this.categoryRepository.findById(id) ?: throw NotFound("Category not found")
        this.categoryRepository.delete(id)
        return true
    }
}