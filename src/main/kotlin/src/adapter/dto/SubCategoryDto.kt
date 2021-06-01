package src.adapter.dto

import src.domain.entities.SubCategory

data class SubCategoryDto(
    var id: Int = 0,
    val name: String = "",
    val categoryId: Int = 0
)

fun SubCategory.toSubCategoryDto() =
    SubCategoryDto(
        id = this.id,
        name = this.name,
        categoryId = this.category
    )

fun SubCategoryDto.toSubCategory() =
    SubCategory(
        id = this.id,
        name = this.name,
        category = this.categoryId
    )
