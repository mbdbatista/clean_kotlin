package src.business.useCases.subCategory

import org.springframework.stereotype.Component
import src.business.errors.AlreadyRegistered
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory

@Component
class UpdateSubCategoryUseCase(private val subCategoryRepository: ISubCategoryRepository) {
    fun exec(id: Int, name: String, categoryId: Int): SubCategory {
        val subCategoryEntity = this.subCategoryRepository.findByName(name)
        if (subCategoryEntity != null) {
            throw AlreadyRegistered("SubCategory already registered")
        }
        return this.subCategoryRepository.update(SubCategory(id, name, categoryId))
    }
}