package src.business.useCases.subCategory

import org.springframework.stereotype.Component
import src.business.errors.AlreadyRegistered
import src.business.errors.NotFound
import src.business.repositories.ICategoryRepository
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory

@Component
class CreateSubCategoryUseCase(
    private val categoryRepository: ICategoryRepository,
    private val subCategoryRepository: ISubCategoryRepository) {
    fun exec(name: String, category: Int): SubCategory {
        this.categoryRepository.findById(category) ?: throw NotFound("Category Not Found")
        val subCategory = this.subCategoryRepository.findByName(name)
        if (subCategory != null) {
            throw AlreadyRegistered("SubCategory already registered")
        }

        return this.subCategoryRepository.create(name, category)
    }
}