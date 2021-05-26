package src.business.errors.message

import src.business.errors.base.DomainError

class MessageNotFound(): DomainError(code = "MSG-001",message = "Message not found") {
}