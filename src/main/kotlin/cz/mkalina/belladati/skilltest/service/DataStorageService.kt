package cz.mkalina.belladati.skilltest.service

import cz.mkalina.belladati.skilltest.persistence.BankEntity
import cz.mkalina.belladati.skilltest.persistence.BankRepository
import org.springframework.stereotype.Service

@Service
class DataStorageService(
        val bankRepository: BankRepository
) {

    fun save(banks: List<Bank>) {
        bankRepository.saveAll(banks.map {
            BankEntity(
                    bankName = it.bankName,
                    bankCode = it.bankCode
            )
        })

    }

}