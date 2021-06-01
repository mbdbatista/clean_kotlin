package src.framework.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import src.adapter.dto.SubCategoryDto
import src.adapter.operators.subCategory.CreateSubCategoryOperator
import src.adapter.operators.subCategory.GetSubCategoryOperator

@RestController
class SubCategoryAPI(
    val createSubCategoryOperator: CreateSubCategoryOperator,
    val getSubCategoryOperator: GetSubCategoryOperator
) {
    @PostMapping("/sub-category")
    fun post(@RequestBody input: SubCategoryDto): ResponseEntity<SubCategoryDto> {
        val response = createSubCategoryOperator.run(input.name, input.categoryId)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/sub-category/{id}")
    fun post(@PathVariable id: Int): ResponseEntity<SubCategoryDto> {
        val response = getSubCategoryOperator.run(id)
        return ResponseEntity(response, HttpStatus.OK)
    }
}