package com.example.app_data.di

import com.example.app_data.net.endpoints.cow.CowRetrofitRepository
import com.example.app_data.net.endpoints.user.UserRetrofitRepository
import com.example.app_data.net.retrofit.AuthTokenInterceptor
import com.example.app_data.net.retrofit.RetrofitFactory
import com.example.app_domain.datacontracts.net.CowNetRepository
import com.example.app_domain.datacontracts.net.UserNetRepository
import okhttp3.Interceptor
import org.koin.core.module.Module

fun Module.provideNetModules(baseUrl: String) {

    provideRetrofit(baseUrl)

    single<UserNetRepository> {
        UserRetrofitRepository(get())
    }
    single<CowNetRepository> {
        CowRetrofitRepository(get())
    }
}


private fun Module.provideRetrofit(
    baseBackendUrl: String,
) {
    single {
        createRetrofit(
            baseBackendUrl,
            AuthTokenInterceptor(get()),
        )
    }
}

private fun createRetrofit(
    baseBackendUrl: String,
    vararg interceptors: Interceptor,
) = RetrofitFactory().create(
    baseBackendUrl,
    *interceptors,
)
