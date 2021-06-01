package src.business.useCases.category

import org.springframework.stereotype.Component
import src.business.errors.AlreadyRegistered
import src.business.errors.NotFound
import src.business.repositories.ICategoryRepository
import src.domain.entities.Category

@Component
class UpdateCategoryUseCase(private val categoryRepository: ICategoryRepository) {
    fun exec(id: Int, name: String): Category {
        val categoryEntity = this.categoryRepository.findByName(name)
        if (categoryEntity != null) {
            throw AlreadyRegistered("Category already registered")
        }
        val category = this.categoryRepository.findById(id) ?: throw NotFound("Category not found")
        return this.categoryRepository.update(Category(category.id, name))
    }
}