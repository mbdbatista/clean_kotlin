package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.serializers.base.BaseError
import src.adapter.serializers.category.create.CreateCategoryInput
import src.adapter.serializers.category.create.CreateCategoryOutput
import src.business.errors.base.DomainError
import src.business.useCases.category.CreateCategoryUseCase

@Component
class CreateCategoryOperator(private val createCategoryUseCase: CreateCategoryUseCase) {
    fun run(input: CreateCategoryInput): CreateCategoryOutput {
        return try {
            val message = this.createCategoryUseCase.exec(input.name)
            CreateCategoryOutput(data = message)
        } catch (error: DomainError) {
            CreateCategoryOutput(error = BaseError(error.code, error.message))
        }
    }
}