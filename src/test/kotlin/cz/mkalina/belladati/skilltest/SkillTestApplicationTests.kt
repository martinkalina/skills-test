package cz.mkalina.belladati.skilltest

import cz.mkalina.belladati.skilltest.persistence.BankRepository
import cz.mkalina.belladati.skilltest.service.Bank
import cz.mkalina.belladati.skilltest.service.DataLoadService
import cz.mkalina.belladati.skilltest.service.DataStorageService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SkillTestApplicationTests {

	@Autowired
	lateinit var dataLoadService: DataLoadService

	@Autowired
	lateinit var dataStorageService: DataStorageService

	@Autowired
	lateinit var bankRepository: BankRepository

	@Test
	fun contextLoads() {
	}

	@Test
	fun test_loadData() {
		val data = dataLoadService.load()
		assert(data.isNotEmpty())
	}

	@Test
	fun test_saveData() {
		val bank = Bank("test_name", "test_code")
		val data = listOf(bank)
		dataStorageService.save(data)
		val all = bankRepository.findAll()
		assertEquals(1, all.size)
		assertEquals(bank.bankName, all.first().bankName)
		assertEquals(bank.bankCode, all.first().bankCode)
	}

}
