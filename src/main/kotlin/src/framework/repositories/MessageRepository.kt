package src.framework.repositories

import src.business.repositories.IMessageRepository
import src.domain.entities.Message
import src.framework.database.operators.IMessageOperator
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MessageRepository(private val messageOperator: IMessageOperator): IMessageRepository {
    override fun findById(id: String): Optional<Message> {
        return messageOperator.findById(id).map { Message(it.id, it.text) }
    }
}