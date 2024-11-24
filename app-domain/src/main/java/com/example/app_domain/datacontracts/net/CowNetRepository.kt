package com.example.app_domain.datacontracts.net

import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairData
import com.example.app_domain.models.cow.CowPairResult
import com.example.app_domain.models.cow.WaitedCowData

interface CowNetRepository {

    suspend fun getAllCows(): List<Cow>

    suspend fun getCowInfo(id: String): Cow

    suspend fun findPair(id: String, findParams: CowPairData): List<CowPairResult>
}