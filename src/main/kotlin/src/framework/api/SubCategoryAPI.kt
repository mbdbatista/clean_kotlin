package src.framework.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import src.adapter.dto.SubCategoryDto
import src.adapter.operators.subCategory.*

@RestController
class SubCategoryAPI(
    val getOperator: GetSubCategoryOperator,
    val createOperator: CreateSubCategoryOperator,
    val listOperator: ListSubCategoryOperator,
    val updateOperator: UpdateSubCategoryOperator,
    val deleteOperator: DeleteSubCategoryOperator,
) {
    @GetMapping("/sub-category/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<SubCategoryDto> {
        val response = getOperator.run(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/sub-category")
    fun list(
        @RequestParam id: Int?,
        @RequestParam name: String?
    ): ResponseEntity<List<SubCategoryDto>> {
        val response = listOperator.run(id, name)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/sub-category/{id}")
    fun put(@PathVariable id: Int, @RequestBody body: SubCategoryDto): ResponseEntity<SubCategoryDto> {
        val dto = body.copy(id = id)
        val response = updateOperator.run(dto)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/sub-category")
    fun post(@RequestBody category: SubCategoryDto): ResponseEntity<SubCategoryDto> {
        val data = createOperator.run(category)
        return ResponseEntity(data, HttpStatus.CREATED)
    }

    @DeleteMapping("/sub-category/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Boolean> {
        deleteOperator.run(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}