package com.example.app_domain.usecases.cow

import com.example.app_domain.datacontracts.net.CowNetRepository
import com.example.app_domain.models.cow.CowPairData

class FindCowPairUseCase(
    private val cowNetRepository: CowNetRepository,
) {

    suspend operator fun invoke(tag: String, pairParams: CowPairData) =
        cowNetRepository.findPair(tag, pairParams)
}