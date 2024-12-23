package com.example.app_domain.datacontracts.net

import com.example.app_domain.models.auth.AuthResponse
import com.example.app_domain.models.user.User

interface UserNetRepository {

    suspend fun login(login: String, password: String): String

    suspend fun getInfo(): User
}