package com.example.app_ui.screens.paircowcard

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairResult
import com.example.app_ui.R
import com.example.app_ui.screens.home.HomeScreen
import com.example.app_ui.screens.success.InstructionNextAction
import com.example.app_ui.screens.success.InstructionScreen
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class PairCowCardPresenter(
    private val params: PairCowCardScreen,
) : BasePresenter<PairCowCardView>() {

    override fun attachView(view: PairCowCardView?) {
        super.attachView(view)
        showCow(params.cowPairResult)
    }

    private fun showCow(cowPairResult: CowPairResult) {
        viewState.showCow(cowPairResult)
    }

    fun onButtonClick() {
        router?.newRootScreen(
            InstructionScreen(
                subtitleRes = R.string.finish_pair_text,
                buttonRes = R.string.finish_pair_button,
                iconRes = R.drawable.check_circle,
                nextAction = InstructionNextAction.ROOT,
                nextScreen = HomeScreen(),
            )
        )
    }

    fun onBack() = router?.exit()
}