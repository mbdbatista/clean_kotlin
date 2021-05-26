package src.domain.types

abstract class MessageType {
    open lateinit var id: String
    open lateinit var text: String
}