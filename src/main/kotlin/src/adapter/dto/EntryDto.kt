package src.adapter.dto

import src.domain.entities.Entry
import java.util.*

data class EntryDto(
    val id: Int,
    val value: Double,
    val date: Date,
    val subCategory: Int?,
    val comment: String?)

fun Entry.toEntryDto() =
    EntryDto(id!!, value, date, subCategory, comment)

fun EntryDto.toEntry() =
    Entry(id, value, date, subCategory, comment)