package useCases.category

import org.junit.Assert.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import src.business.repositories.ICategoryRepository
import src.business.useCases.category.CreateCategoryUseCase
import src.domain.entities.Category

@RunWith(MockitoJUnitRunner::class)
class CreateCategoryUseCaseTest {
    @InjectMocks
    lateinit var createCategoryUseCase: CreateCategoryUseCase

    @Mock
    lateinit var categoryRepository: ICategoryRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun createCategory() {
        val categoryMock = Category(
            id = 1,
            name = "Categoria 1"
        )
        `when`(categoryRepository.create(categoryMock.name)).thenReturn(categoryMock)

        val category = createCategoryUseCase.exec(categoryMock.name)

        assertTrue(category.id == categoryMock.id)
    }
}