package src.domain.entities

data class SubCategory(val id: Int, val name: String, val category: Int, val entries: List<Entry> = emptyList())
