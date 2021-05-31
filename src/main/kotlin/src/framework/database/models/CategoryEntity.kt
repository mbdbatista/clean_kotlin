package src.framework.database.models

import src.domain.entities.Category
import javax.persistence.*

@Table(name = "categoria")
@Entity
data class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    val id: Int? = 0,

    @Column(nullable = false, name = "nome")
    val name: String? = "",

    @OneToMany(mappedBy = "categoria", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val subCategories: List<SubCategoryEntity> = emptyList()
)

fun CategoryEntity.toCategory() = Category(this.id!!, this.name!!)
fun Category.toCategoryEntity() = CategoryEntity(this.id, this.name)