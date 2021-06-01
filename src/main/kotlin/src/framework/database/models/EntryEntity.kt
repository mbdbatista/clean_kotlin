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

    @Column(name = "id_subcategoria")
    val subCategory: Int? = null
)

fun EntryEntity.toEntry() =
    Entry(
        id = this.id!!,
        value = this.value!!,
        date = this.date!!,
        comment = this.comment!!,
        subCategory = this.subCategory
    )

fun Entry.toEntryEntity() =
    EntryEntity(
        id = this.id,
        value = this.value,
        date = this.date,
        comment = this.comment,
        subCategory = this.subCategory
    )
