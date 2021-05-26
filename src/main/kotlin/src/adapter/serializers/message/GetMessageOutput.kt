package src.adapter.serializers.message

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.base.BaseOutput
import src.domain.types.MessageType

data class GetMessageOutput(override val data: MessageType? = null, override val error: BaseError? = null) : BaseOutput<MessageType>
