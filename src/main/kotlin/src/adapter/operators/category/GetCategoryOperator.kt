package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.dto.CategoryDto
import src.adapter.dto.toCategoryDto
import src.business.useCases.category.GetCategoryUseCase

@Component
class GetCategoryOperator(private val getCategoryUseCase: GetCategoryUseCase) {
    fun run(id: Int): CategoryDto {
        val message = this.getCategoryUseCase.exec(id)
        return message.toCategoryDto()
    }
}