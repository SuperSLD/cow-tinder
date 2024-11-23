package com.example.app_domain.datacontracts.net

import com.example.app_domain.models.cow.Cow

interface CowNetRepository {

    suspend fun getAllCows(): List<Cow>

    suspend fun getCowInfo(id: String): Cow
}