package src.domain.entities

data class Balance(val category: Category? = null, val revenue: Double, val disbursement: Double, val balance: Double)
