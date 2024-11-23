package com.example.app_domain.datacontracts.config

interface ConfigRepository {

    fun putValue(configKey: ConfigKey, value: String)

    fun getValue(configKey: ConfigKey): String
}