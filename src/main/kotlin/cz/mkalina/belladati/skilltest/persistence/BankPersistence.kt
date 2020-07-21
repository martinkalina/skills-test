package cz.mkalina.belladati.skilltest.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*


@Entity
data class BankEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        val id: Long = 0,
        val bankName: String,
        val bankCode: String
)

@Repository
interface BankRepository : JpaRepository<BankEntity, Long>