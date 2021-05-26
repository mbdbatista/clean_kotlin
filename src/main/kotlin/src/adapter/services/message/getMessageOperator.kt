package src.adapter.services.message

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.message.GetMessageInput
import src.adapter.serializers.message.GetMessageOutput
import src.business.errors.base.DomainError
import src.business.useCases.GetMessageUseCase
import org.springframework.stereotype.Component

interface IGetMessageService {
    fun run(input: GetMessageInput): GetMessageOutput
}
@Component
class GetMessageService(private val getMessageUseCase: GetMessageUseCase): IGetMessageService {
        override fun run(input: GetMessageInput): GetMessageOutput {
        return try {
            val message = this.getMessageUseCase.exec(input.id)
            GetMessageOutput(data = message)
        } catch (error: DomainError) {
            GetMessageOutput(error = BaseError(error.code, error.message))
        }
    }
}