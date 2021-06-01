package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.dto.CategoryDto
import src.adapter.dto.toCategoryDto
import src.business.useCases.category.CreateCategoryUseCase

@Component
class CreateCategoryOperator(private val createCategoryUseCase: CreateCategoryUseCase) {
    fun run(input: CategoryDto): CategoryDto {
        val category = this.createCategoryUseCase.exec(input.name)
        return category.toCategoryDto()
    }
}