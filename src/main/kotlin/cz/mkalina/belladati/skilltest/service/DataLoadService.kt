package cz.mkalina.belladati.skilltest.service

import com.belladati.sdk.BellaDati
import com.belladati.sdk.BellaDatiService
import com.belladati.sdk.dataset.data.DataRow
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service

class DataLoadService(

        @Value("\${belladati.key}") key: String,
        @Value("\${belladati.secret}") secret: String,
        @Value("\${belladati.user}") user: String,
        @Value("\${belladati.password}") password: String

) {
    val service: BellaDatiService = BellaDati.connectInsecure("https://service.belladati.com").xAuth(key, secret, user, password)


    fun load(): List<Bank> {
        service.dataSetInfo.load()
        val dataSet = service.loadDataSet(service.dataSetInfo.first { it.name == "mkalina-set" }.id)
        return dataSet.data.load().map {
            Bank(it.readContent(0), it.readContent(1))
        }
    }
}

private fun DataRow.readContent(i: Int): String = get(this.columns[i].code)

data class Bank(
        val bankName: String,
        val bankCode: String
)