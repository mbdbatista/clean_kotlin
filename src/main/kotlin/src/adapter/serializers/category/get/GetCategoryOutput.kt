package src.adapter.serializers.category.get

import src.adapter.serializers.base.BaseError
import src.adapter.serializers.base.BaseOutput
import src.domain.types.CategoryType

data class GetCategoryOutput(override val data: CategoryType? = null, override val error: BaseError? = null): BaseOutput<CategoryType>