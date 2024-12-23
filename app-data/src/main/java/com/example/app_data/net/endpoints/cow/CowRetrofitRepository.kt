package com.example.app_data.net.endpoints.cow

import com.example.app_domain.datacontracts.net.CowNetRepository
import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairData
import com.example.app_domain.models.cow.CowPairResult
import com.example.app_domain.models.cow.WaitedCowData
import retrofit2.Retrofit
import java.lang.Thread.sleep

class CowRetrofitRepository(
    retrofit: Retrofit
): CowNetRepository {

    private val service by lazy { retrofit.create(CowRetrofitService::class.java) }

    override suspend fun getAllCows(): List<Cow> {
        return service.allCows().dataOrThrow() ?: error("Пусто")
    }

    override suspend fun getCowInfo(id: String): Cow {
        return service.findCow(id).dataOrThrow() ?: error("Не найдено")
    }

    override suspend fun findPair(id: String, findParams: CowPairData): List<CowPairResult> {
        return service.findPair(findParams).dataOrThrow() ?: error("Ошибка")
    }
}

private fun createMockCow() = Cow(
    id = "123456",
    sex = "Самка",
    breed = "Герефорд",
    birthDate = "22.12.2022",
    papa = "",
    mama = "",
    milkVolume = "37.47",
    meatVolume = "5",
    inbreeding = "",
    meatIncrement = "",
    health = "8",
    fertility = "79",
    geneticValue = "",
)