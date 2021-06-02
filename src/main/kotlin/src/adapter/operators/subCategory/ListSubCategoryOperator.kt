package src.adapter.operators.subCategory

import org.springframework.stereotype.Component
import src.adapter.dto.SubCategoryDto
import src.adapter.dto.toSubCategoryDto
import src.business.useCases.subCategory.ListSubCategoryUseCase

@Component
class ListSubCategoryOperator(private val listSubCategoryUseCase: ListSubCategoryUseCase) {
    fun run(id: Int?, name: String?): List<SubCategoryDto> {
        val subCategory = this.listSubCategoryUseCase.exec(id, name)
        return subCategory.map { it.toSubCategoryDto() }
    }
}