package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category

@Component
class ListCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(name: String? = null): List<Category> {
        return this.categoryRepository.findAllByName(name)
    }
}