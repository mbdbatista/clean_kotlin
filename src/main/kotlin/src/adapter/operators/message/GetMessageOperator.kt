package src.adapter.operators.message

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.message.GetMessageInput
import src.adapter.serializers.message.GetMessageOutput
import src.business.errors.base.DomainError
import src.business.useCases.GetMessageUseCase
import org.springframework.stereotype.Component

@Component
class GetMessageOperator(private val getMessageUseCase: GetMessageUseCase) {
        fun run(input: GetMessageInput): GetMessageOutput {
        return try {
            val message = this.getMessageUseCase.exec(input.id)
            GetMessageOutput(data = message)
        } catch (error: DomainError) {
            GetMessageOutput(error = BaseError(error.code, error.message))
        }
    }
}