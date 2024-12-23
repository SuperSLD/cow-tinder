package com.example.app_data.net.endpoints.user

import com.example.app_domain.datacontracts.net.UserNetRepository
import com.example.app_domain.models.auth.AuthResponse
import com.example.app_domain.models.user.User
import retrofit2.Retrofit

class UserRetrofitRepository(
    retrofit: Retrofit,
) : UserNetRepository {

    private val service by lazy { retrofit.create(UserRetrofitService::class.java) }

    override suspend fun login(login: String, password: String): String {
        return service.login(LoginRequest(login, password)).dataOrThrow()!!
    }


    override suspend fun getInfo(): User {
        return service.getInfo().dataOrThrow()!!
    }
}
