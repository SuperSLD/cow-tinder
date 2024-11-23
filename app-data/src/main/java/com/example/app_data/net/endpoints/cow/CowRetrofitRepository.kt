package com.example.app_data.net.endpoints.cow

import com.example.app_domain.datacontracts.net.CowNetRepository
import com.example.app_domain.models.cow.Cow
import retrofit2.Retrofit

class CowRetrofitRepository(
    retrofit: Retrofit
): CowNetRepository {

    private val service by lazy { retrofit.create(CowRetrofitService::class.java) }
    override suspend fun getAllCows(): List<Cow> {
        TODO("Not yet implemented")
    }

    override suspend fun getCowInfo(id: String): Cow {
        TODO("Not yet implemented")
    }
}