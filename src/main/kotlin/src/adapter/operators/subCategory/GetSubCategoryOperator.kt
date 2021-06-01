package src.adapter.operators.subCategory

import org.springframework.stereotype.Component
import src.adapter.dto.SubCategoryDto
import src.adapter.dto.toSubCategoryDto
import src.business.useCases.subCategory.GetSubCategoryUseCase

@Component
class GetSubCategoryOperator(
    val getSubCategoryUseCase: GetSubCategoryUseCase
) {
    fun run(id: Int): SubCategoryDto {
        val message = this.getSubCategoryUseCase.exec(id)
        return message.toSubCategoryDto()
    }
}