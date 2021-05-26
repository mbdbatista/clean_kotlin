package src.framework.database.operators

import src.framework.database.models.MessageEntity
import org.springframework.data.repository.CrudRepository

interface IMessageOperator: CrudRepository<MessageEntity, String> {
}