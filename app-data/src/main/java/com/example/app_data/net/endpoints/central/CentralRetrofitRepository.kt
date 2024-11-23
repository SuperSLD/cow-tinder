package com.example.app_data.net.endpoints.central

import com.example.app_domain.datacontracts.net.CentralNetRepository
import com.example.app_domain.models.central.Central
import retrofit2.Retrofit

class CentralRetrofitRepository(
    retrofit: Retrofit,
) : CentralNetRepository {

    private val service by lazy { retrofit.create(CentralRetrofitService::class.java) }

    override suspend fun get(): Central {
        return service.get().dataOrThrow()!!
    }
}
