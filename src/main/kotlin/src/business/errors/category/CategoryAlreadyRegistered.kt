package src.business.errors.category

import src.business.errors.base.DomainError

class CategoryAlreadyRegistered(): DomainError(code = "CTG-002",message = "Category already registered") {
}