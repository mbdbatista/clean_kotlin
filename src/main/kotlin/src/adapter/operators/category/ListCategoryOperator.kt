package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.dto.CategoryDto
import src.adapter.dto.toCategoryDto
import src.business.useCases.category.ListCategoryUseCase

@Component
class ListCategoryOperator(private val listCategoryUseCase: ListCategoryUseCase) {
    fun run(name: String?): List<CategoryDto> {
        val message = this.listCategoryUseCase.exec(name)
        return message.map { it.toCategoryDto() }
    }
}