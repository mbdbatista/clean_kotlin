package src.adapter.dto

import src.domain.entities.Balance

data class BalanceDto(
    val category: CategoryDto? = null,
    val revenue: Double,
    val disbursement: Double,
    val balance: Double)

fun Balance.toBalanceDto() =
    BalanceDto(
        category?.toCategoryDto(),
        revenue,
        disbursement,
        balance)

fun BalanceDto.toBalance() =
    Balance(
        category?.toCategory(),
        revenue,
        disbursement,
        balance
    )

