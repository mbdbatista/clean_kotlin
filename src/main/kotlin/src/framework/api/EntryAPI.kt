package src.framework.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import src.adapter.dto.EntryDto
import src.adapter.operators.entry.*
import java.util.*

@RestController
class EntryAPI(
    val getOperator: GetEntryOperator,
    val createOperator: CreateEntryOperator,
    val listOperator: ListEntryOperator,
    val updateOperator: UpdateEntryOperator,
    val deleteOperator: DeleteEntryOperator,
) {
    @GetMapping("/entry/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<EntryDto> {
        val response = getOperator.run(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/entry")
    fun list(
        @RequestParam startDate: Date?,
        @RequestParam endDate: Date?,
        @RequestParam subCategoryId: Int?,
    ): ResponseEntity<List<EntryDto>> {
        val response = listOperator.run(startDate, endDate, subCategoryId)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/entry/{id}")
    fun put(@PathVariable id: Int, @RequestBody body: EntryDto): ResponseEntity<EntryDto> {
        val dto = body.copy(id = id)
        val response = updateOperator.run(dto)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/entry")
    fun post(@RequestBody category: EntryDto): ResponseEntity<EntryDto> {
        val data = createOperator.run(category)
        return ResponseEntity(data, HttpStatus.CREATED)
    }

    @DeleteMapping("/entry/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Boolean> {
        deleteOperator.run(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}