package src.framework.database.operators

import org.springframework.data.jpa.repository.JpaRepository
import src.framework.database.models.EntryEntity

interface IEntryOperator: JpaRepository<EntryEntity, Int> {
}