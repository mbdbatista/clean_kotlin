package src.adapter.operators.subCategory

import org.springframework.stereotype.Component
import src.business.useCases.subCategory.DeleteSubCategoryUseCase

@Component
class DeleteSubCategoryOperator(
    val deleteSubCategoryUseCase: DeleteSubCategoryUseCase
) {
    fun run(id: Int): Boolean {
        return this.deleteSubCategoryUseCase.exec(id)
    }
}