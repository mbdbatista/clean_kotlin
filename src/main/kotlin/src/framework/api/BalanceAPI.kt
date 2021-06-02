package src.framework.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import src.adapter.dto.BalanceDto
import src.adapter.operators.balance.GetBalanceOperator
import java.util.*

@RestController
class BalanceAPI(
    val getOperator: GetBalanceOperator
) {
    @GetMapping("/balance")
    fun get(
        @RequestParam startDate: Date,
        @RequestParam endDate: Date,
        @RequestParam categoryId: Int?
    ): ResponseEntity<BalanceDto> {
        val response = getOperator.run(startDate, endDate, categoryId)
        return ResponseEntity(response, HttpStatus.OK)
    }
}