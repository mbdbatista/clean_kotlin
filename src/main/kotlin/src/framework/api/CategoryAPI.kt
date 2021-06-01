package src.framework.api

import org.springframework.http.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import src.adapter.operators.category.*
import src.adapter.dto.CategoryDto
import src.domain.entities.Category

@RestController
class CategoryAPI(
    val getOperator: GetCategoryOperator,
    val createOperator: CreateCategoryOperator,
    val listOperator: ListCategoryOperator,
    val updateOperator: UpdateCategoryOperator,
    val deleteOperator: DeleteCategoryOperator,
    ) {
    @GetMapping("/category/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<CategoryDto> {
        val response = getOperator.run(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/category")
    fun list(@RequestParam(required = false) name: String?): ResponseEntity<List<CategoryDto>> {
        val response = listOperator.run(name)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/category/{id}")
    fun put(@PathVariable id: Int, @RequestBody body: Category): ResponseEntity<CategoryDto> {
        val response = updateOperator.run(id, body.name)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/category")
    fun post(@RequestBody category: CategoryDto): ResponseEntity<CategoryDto> {
        val data = createOperator.run(category)
        return ResponseEntity(data, HttpStatus.CREATED)
    }

    @DeleteMapping("/category/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Boolean> {
        deleteOperator.run(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}