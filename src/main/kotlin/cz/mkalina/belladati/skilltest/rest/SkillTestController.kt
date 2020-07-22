package cz.mkalina.belladati.skilltest.rest

import cz.mkalina.belladati.skilltest.service.Bank
import cz.mkalina.belladati.skilltest.service.DataLoadService
import cz.mkalina.belladati.skilltest.service.DataStorageService
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
        val dataStorageService: DataStorageService
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
            model: Model,
            @ModelAttribute("banks") banks: List<Bank>): String {
        dataStorageService.save(banks)
        model.addAttribute("showPopup", "true")
        return "list"
    }

}