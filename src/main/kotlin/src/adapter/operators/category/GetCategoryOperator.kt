package src.adapter.operators.category

import org.springframework.stereotype.Component
import src.adapter.serializers.base.BaseError
import src.adapter.serializers.category.get.GetCategoryInput
import src.adapter.serializers.category.get.GetCategoryOutput
import src.business.errors.base.DomainError
import src.business.useCases.category.GetCategoryUseCase

@Component
class GetCategoryOperator(private val getCategoryUseCase: GetCategoryUseCase) {
    fun run(input: GetCategoryInput): GetCategoryOutput {
        return try {
            val message = this.getCategoryUseCase.exec(input.id)
            GetCategoryOutput(data = message)
        } catch (error: DomainError) {
            GetCategoryOutput(error = BaseError(error.code, error.message))
        }
    }
}