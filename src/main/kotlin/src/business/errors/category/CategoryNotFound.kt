package src.business.errors.category

import src.business.errors.base.DomainError

class CategoryNotFound(): DomainError(code = "CTG-001",message = "Category not found") {
}