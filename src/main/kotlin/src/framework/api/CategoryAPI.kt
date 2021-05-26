package src.framework.api

import org.springframework.web.bind.annotation.*
import src.adapter.operators.category.CreateCategoryOperator
import src.adapter.operators.category.GetCategoryOperator
import src.adapter.serializers.category.create.CreateCategoryInput
import src.adapter.serializers.category.create.CreateCategoryOutput
import src.adapter.serializers.category.get.GetCategoryInput
import src.adapter.serializers.category.get.GetCategoryOutput
import src.domain.entities.Category

@RestController
class CategoryAPI(
    val getOperator: GetCategoryOperator,
    val createOperator: CreateCategoryOperator,
    ) {
    @GetMapping("/category/{id}")
    fun get(@PathVariable id: Int): GetCategoryOutput {
        val input = GetCategoryInput(id)
        return getOperator.run(input)
    }

    @PostMapping("/category")
    fun post(@RequestBody category: Category): CreateCategoryOutput {
        val input = CreateCategoryInput(category.name)
        return createOperator.run(input)
    }
}