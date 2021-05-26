package src.framework.api
import src.adapter.serializers.message.GetMessageInput
import src.adapter.serializers.message.GetMessageOutput
import src.adapter.services.message.IGetMessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageAPI(val service: IGetMessageService) {
    @GetMapping("/message/{id}")
    fun get(@PathVariable id: String): GetMessageOutput {
        val input = GetMessageInput(id)
        return service.run(input)
    }
}