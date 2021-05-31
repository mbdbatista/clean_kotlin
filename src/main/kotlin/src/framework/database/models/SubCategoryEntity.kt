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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    val category: CategoryEntity? = null,

    @OneToMany(mappedBy = "lancamento", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val entries: List<EntryEntity> = emptyList()
)

fun SubCategoryEntity.toSubCategory() = SubCategory(
    id = this.id!!,
    name = this.name!!,
    category = this.category!!.toCategory()
)

fun SubCategory.toSubCategoryEntity() = SubCategoryEntity(
    id = this.id,
    name = this.name,
    category = this.category!!.toCategoryEntity()
)