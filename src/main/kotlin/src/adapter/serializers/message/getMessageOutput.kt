package src.adapter.serializers.message

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.base.BaseOutput
import src.domain.entities.Message

data class GetMessageOutput(override val data: Message? = null, override val error: BaseError? = null) : BaseOutput<Message>
