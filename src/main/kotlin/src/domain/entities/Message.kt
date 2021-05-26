package src.domain.entities

import src.domain.types.MessageType

class Message private constructor(): MessageType() {
    constructor(id: String, text: String): this() {
        this.id = id
        this.text = text
    }
}