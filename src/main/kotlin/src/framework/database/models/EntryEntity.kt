package src.framework.database.models

import src.domain.entities.Entry
import java.util.*
import javax.persistence.*

@Table(name = "lancamento")
@Entity
data class EntryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lancamento")
    val id: Int? = 0,

    @Column(nullable = false, name = "valor")
    val value: Double? = 0.0,

    @Column(nullable = false, name = "data")
    val date: Date? = null,

    @Column(nullable = false, name = "comentario")
    val comment: String? = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_subcategoria")
    val subCategory: SubCategoryEntity? = null
)

fun EntryEntity.toEntry() =
    Entry(
        id = this.id!!,
        value = this.value!!,
        date = this.date!!,
        comment = this.comment!!,
        subCategory = if(this.subCategory != null) this.subCategory.toSubCategory() else null
    )

fun Entry.toEntryEntity() =
    EntryEntity(
        id = this.id,
        value = this.value,
        date = this.date,
        comment = this.comment,
        subCategory = if(this.subCategory != null) this.subCategory.toSubCategoryEntity() else null
    )
