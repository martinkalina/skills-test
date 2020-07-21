package cz.mkalina.belladati.skilltest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class SkillTestApplication

fun main(args: Array<String>) {
	runApplication<SkillTestApplication>(*args)
}
