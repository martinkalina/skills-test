package cz.mkalina.belladati.skilltest

import cz.mkalina.belladati.skilltest.persistence.BankRepository
import cz.mkalina.belladati.skilltest.service.Bank
import cz.mkalina.belladati.skilltest.service.DataLoadService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SkillTestApplicationTests {

	@Autowired
	lateinit var dataLoadService: DataLoadService

	@Test
	fun contextLoads() {
	}

	@Test
	fun test_loadData() {
		val data = dataLoadService.load()
		assert(data.isNotEmpty())
	}

}
