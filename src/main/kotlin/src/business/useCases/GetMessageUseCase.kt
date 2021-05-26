package src.business.useCases

import org.springframework.stereotype.Component
import src.business.errors.message.MessageNotFound
import src.business.repositories.IMessageRepository
import src.domain.entities.Message

@Component
class GetMessageUseCase(private val messageRepository: IMessageRepository) {
    fun exec(id: String): Message {
        val message = this.messageRepository.findById(id)
        if (message.isEmpty) {
            throw MessageNotFound()
        }
        return message.get()
    }
}