package com.example.app_ui.screens.paircowcard

import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairResult
import com.example.app_ui.common.AppScreen

class PairCowCardScreen(
    val cowPairResult: CowPairResult,
) : AppScreen() {

    override fun getFragment() = PairCowCardFragment.newInstance(this)
}