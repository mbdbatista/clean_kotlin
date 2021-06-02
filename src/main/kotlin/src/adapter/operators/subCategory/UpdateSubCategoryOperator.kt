package src.adapter.operators.subCategory

import org.springframework.stereotype.Component
import src.adapter.dto.SubCategoryDto
import src.adapter.dto.toSubCategoryDto
import src.business.useCases.subCategory.UpdateSubCategoryUseCase

@Component
class UpdateSubCategoryOperator(private val updateSubCategoryUseCase: UpdateSubCategoryUseCase) {
    fun run(input: SubCategoryDto): SubCategoryDto {
        val subCategory = this.updateSubCategoryUseCase.exec(input.id, input.name, input.categoryId)
        return subCategory.toSubCategoryDto()
    }
}