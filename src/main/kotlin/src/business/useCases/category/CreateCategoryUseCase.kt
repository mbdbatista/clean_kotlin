package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.AlreadyRegistered
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category

@Component
class CreateCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(name: String): Category {
        val category = this.categoryRepository.findByName(name)
        if (category != null) {
            throw AlreadyRegistered("Category already registered")
        }
        return this.categoryRepository.create(name)
    }
}