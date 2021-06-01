package src.adapter.operators.subCategory

import org.springframework.stereotype.Component
import src.adapter.dto.SubCategoryDto
import src.adapter.dto.toSubCategoryDto
import src.business.useCases.subCategory.CreateSubCategoryUseCase

@Component
class CreateSubCategoryOperator(
    val createSubCategoryUseCase: CreateSubCategoryUseCase
) {
    fun run(name: String, category: Int): SubCategoryDto {
        val message = this.createSubCategoryUseCase.exec(name, category)
        return message.toSubCategoryDto()
    }
}