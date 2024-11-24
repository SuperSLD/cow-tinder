package com.example.app_domain.usecases.user

import com.example.app_domain.datacontracts.config.ConfigKey
import com.example.app_domain.datacontracts.config.ConfigRepository
import com.example.app_domain.datacontracts.net.UserNetRepository
import com.example.app_domain.models.auth.AuthResponse

class LoginUseCase(
    private val userNetRepository: UserNetRepository,
    private val configRepository: ConfigRepository,
) {

    suspend operator fun invoke(login: String, password: String): String {
        val authResponse = userNetRepository.login(login, password)
        configRepository.putValue(ConfigKey.AUTH_TOKEN, authResponse)
        return authResponse
    }
}