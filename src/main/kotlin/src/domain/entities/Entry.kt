package src.domain.entities

import java.util.*

data class Entry(val id: Int, val value: Double, val date: Date, val subCategory: SubCategory?, val comment: String)
