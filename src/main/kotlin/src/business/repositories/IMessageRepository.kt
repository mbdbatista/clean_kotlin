package src.business.repositories

import src.domain.entities.Message
import java.util.*

interface IMessageRepository {
    fun findById(id: String): Optional<Message>
}