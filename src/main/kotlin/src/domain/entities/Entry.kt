package src.domain.entities

import java.util.*

data class Entry(val id: Int? = 0, val value: Double, val date: Date, val subCategory: Int?, val comment: String?)
