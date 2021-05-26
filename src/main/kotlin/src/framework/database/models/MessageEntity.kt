package src.framework.database.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import src.domain.types.MessageType

@Table("MESSAGES")
data class MessageEntity(@Id override var id: String, override var text: String): MessageType()
