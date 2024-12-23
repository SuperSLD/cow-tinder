package com.example.app_ui.screens.best_partners

import com.example.app_domain.models.cow.CowPairResult
import com.example.app_ui.common.AppScreen

class BestPartnerScreen(
    val cowPairResultList: List<CowPairResult>,
): AppScreen() {

    override fun getFragment() = BestPartnersFragment.newInstance(this)
}