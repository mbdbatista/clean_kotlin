package src.adapter.serializers.category.create

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.base.BaseOutput
import src.domain.entities.Category

data class CreateCategoryOutput(override val data: Category? = null, override val error: BaseError? = null) : BaseOutput<Category>
