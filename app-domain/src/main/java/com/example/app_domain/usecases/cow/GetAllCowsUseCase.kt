package com.example.app_domain.usecases.cow

import com.example.app_domain.datacontracts.net.CowNetRepository

class GetAllCowsUseCase(
    private val cowNetRepository: CowNetRepository,
) {

    suspend operator fun invoke() = cowNetRepository.getAllCows()
}