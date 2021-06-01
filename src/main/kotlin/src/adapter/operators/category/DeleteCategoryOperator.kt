package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.business.useCases.category.DeleteCategoryUseCase

@Component
class DeleteCategoryOperator(private val deleteCategoryUseCase: DeleteCategoryUseCase) {
    fun run(id: Int): Boolean {
        return this.deleteCategoryUseCase.exec(id)
    }
}