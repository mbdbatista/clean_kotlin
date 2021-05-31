package src.domain.entities

data class Category (val id: Int, val name: String, val subCategories: List<SubCategory> = emptyList())