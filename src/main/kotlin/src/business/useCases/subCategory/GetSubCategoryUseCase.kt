package src.business.useCases.subCategory

import org.springframework.stereotype.Component
import src.business.errors.NotFound
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory

@Component
class GetSubCategoryUseCase(private val subCategoryRepository: ISubCategoryRepository) {
    fun exec(id: Int): SubCategory {
        return this.subCategoryRepository.findById(id) ?: throw NotFound("Sub Category Not Found")
    }
}