package src.framework.database.models

import src.domain.entities.MessageType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MESSAGES")
data class MessageEntity(@Id override var id: String, override var text: String): MessageType()
