package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.dto.CategoryDto
import src.adapter.dto.toCategoryDto
import src.business.useCases.category.UpdateCategoryUseCase

@Component
class UpdateCategoryOperator(private val updateCategoryUseCase: UpdateCategoryUseCase) {
    fun run(id: Int, name: String): CategoryDto {
        val message = this.updateCategoryUseCase.exec(id, name)
        return message.toCategoryDto()
    }
}