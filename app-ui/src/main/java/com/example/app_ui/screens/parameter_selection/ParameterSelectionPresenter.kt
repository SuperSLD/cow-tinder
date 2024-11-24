package com.example.app_ui.screens.parameter_selection

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.CowPairData
import com.example.app_domain.usecases.cow.FindCowPairUseCase
import com.example.app_ui.common.core.base.launchUI
import com.example.app_ui.common.core.base.withIO
import com.example.app_ui.screens.best_partners.BestPartnerScreen
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class ParameterSelectionPresenter(
    private val params: ParameterSelectionScreen
): BasePresenter<ParameterSelectionView>() {

    private val findPairUseCase: FindCowPairUseCase by inject()
    private var maxParam = 0

    fun onBack() = router?.exit()

    fun onSearch(
        milk: List<Float>,
        weight: List<Float>,
        health: List<Float>,
    ) {
        launchUI {
            val cowPairData = CowPairData(
                cowTag = params.cowId,
                maximisationParam = maxParam,
                milk = milk,
                weight = weight,
                health = health
            )

            viewState.toggleLoading(true)
            val answer = withIO { findPairUseCase.invoke(tag = params.cowId, pairParams = cowPairData) }
            viewState.toggleLoading(false)
            router?.navigateTo(
                BestPartnerScreen(
                    cowPairResultList = answer,
                )
            )
        }
    }

    fun onMainParameterChange(maximisationParam: Int) {
        maxParam = maximisationParam
    }
}