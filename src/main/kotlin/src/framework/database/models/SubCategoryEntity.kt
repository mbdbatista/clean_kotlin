package src.framework.database.models

import src.domain.entities.SubCategory
import javax.persistence.*
@Table(name = "subcategoria")
@Entity
data class SubCategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    val id: Int? = 0,

    @Column(nullable = false, name = "nome")
    val name: String? = "",

    @Column(name = "id_categoria")
    val category: Int? = 0,

    @OneToMany(mappedBy = "subCategory", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val entries: List<EntryEntity> = emptyList()
)

fun SubCategoryEntity.toSubCategory() = SubCategory(
    id = this.id!!,
    name = this.name!!,
    category = this.category!!
)

fun SubCategory.toSubCategoryEntity() = SubCategoryEntity(
    id = this.id,
    name = this.name,
    category = this.category
)