package src.business.useCases.subCategory

import org.springframework.stereotype.Component
import src.business.repositories.ISubCategoryRepository
import src.domain.entities.SubCategory

@Component
class ListSubCategoryUseCase(private val subCategoryRepository: ISubCategoryRepository) {
    fun exec(id: Int?, name: String?): List<SubCategory> {
        return if (id == null || name.isNullOrEmpty()) {
            this.subCategoryRepository.findAll()
        } else {
            this.subCategoryRepository.list(name, id)
        }
    }
}