package cz.mkalina.belladati.skilltest.rest

import cz.mkalina.belladati.skilltest.persistence.BankEntity
import cz.mkalina.belladati.skilltest.persistence.BankRepository
import cz.mkalina.belladati.skilltest.service.Bank
import cz.mkalina.belladati.skilltest.service.DataLoadService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.SessionAttributes


@Controller
@SessionAttributes("banks")
class SkillTestController(
        val dataLoadService: DataLoadService,
        val bankRepository: BankRepository
) {

    @ModelAttribute("banks")
    fun loadBanks(): List<Bank> {
        return dataLoadService.load()
    }

    @GetMapping
    fun list(
            model: Model,
            @ModelAttribute("banks") banks: List<Bank>
    ): String {
        model.addAttribute("banks", banks)
        return "list"
    }

    @PostMapping
    fun store(
            @ModelAttribute("banks") banks: List<Bank>): String {
            bankRepository.saveAll(banks.map {
            BankEntity(
                    bankName =  it.bankName,
                    bankCode =  it.bankCode
            )
        })
        return "list"

    }


}