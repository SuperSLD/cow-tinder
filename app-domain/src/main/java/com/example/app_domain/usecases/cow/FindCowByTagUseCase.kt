package com.example.app_domain.usecases.cow

import com.example.app_domain.datacontracts.net.CowNetRepository

class FindCowByTagUseCase(
    private val cowNetRepository: CowNetRepository,
) {

    suspend operator fun invoke(tag: String) = cowNetRepository.getCowInfo(tag)
}