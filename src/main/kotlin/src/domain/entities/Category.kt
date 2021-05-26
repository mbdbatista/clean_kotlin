package src.domain.entities

import src.domain.types.CategoryType


class Category private constructor(): CategoryType() {
    constructor(id: Int, name: String): this() {
        this.id = id
        this.name = name
    }
}