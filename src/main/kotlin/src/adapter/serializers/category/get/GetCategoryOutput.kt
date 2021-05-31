package src.adapter.serializers.category.get

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.base.BaseOutput
import src.domain.entities.Category

data class GetCategoryOutput(override val data: Category? = null, override val error: BaseError? = null): BaseOutput<Category>