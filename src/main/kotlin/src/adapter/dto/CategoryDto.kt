package src.adapter.dto

import src.domain.entities.Category

data class CategoryDto(
    var id: Int = 0,
    val name: String = ""
)

fun Category.toCategoryDto() =
    CategoryDto(
        id = this.id,
        name = this.name
    )

fun CategoryDto.toCategory() =
    Category(
        id = this.id,
        name = this.name
    )
