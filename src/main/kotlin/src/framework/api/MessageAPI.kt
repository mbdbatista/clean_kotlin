package src.framework.api
import src.adapter.serializers.message.GetMessageInput
import src.adapter.serializers.message.GetMessageOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import src.adapter.operators.message.GetMessageOperator

@RestController
class MessageAPI(val operator: GetMessageOperator) {
    @GetMapping("/message/{id}")
    fun get(@PathVariable id: String): GetMessageOutput {
        val input = GetMessageInput(id)
        return operator.run(input)
    }
}