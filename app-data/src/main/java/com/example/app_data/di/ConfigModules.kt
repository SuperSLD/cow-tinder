package com.example.app_data.di

import com.example.app_domain.datacontracts.config.ConfigRepository
import com.example.data.config.ConfigPreferenceRepository
import org.koin.core.module.Module

fun Module.provideConfigModules() {

    single<ConfigRepository> {
        ConfigPreferenceRepository(get())
    }
}