package src.adapter.operators.balance

import org.springframework.stereotype.Component
import src.adapter.dto.BalanceDto
import src.adapter.dto.toBalanceDto
import src.business.useCases.balance.GetBalanceUseCase
import java.util.*

@Component
class GetBalanceOperator(val getBalanceUseCase: GetBalanceUseCase) {
    fun run(startDate: Date, endDate: Date, categoryId: Int?): BalanceDto {
        val balance = this.getBalanceUseCase.exec(startDate, endDate, categoryId)
        return balance.toBalanceDto()
    }
}