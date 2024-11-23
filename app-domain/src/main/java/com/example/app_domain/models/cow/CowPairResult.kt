package com.example.app_domain.models.cow

data class CowPairResult(
    val otherCow: Cow,
    val waitedCowData: WaitedCowData,
)

data class WaitedCowData(
    val milk: Float,
    val weight: Float,
    val health: Float,
    val fertility: Float,
)
