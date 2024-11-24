package com.example.app_ui.screens.best_partners

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.R
import com.example.app_ui.screens.cowcard.CowCardNextAction
import com.example.app_ui.screens.cowcard.CowCardScreen
import com.example.app_ui.screens.parameter_selection.ParameterSelectionScreen
import com.example.app_ui.screens.success.InstructionNextAction
import com.example.app_ui.screens.success.InstructionScreen
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class BestPartnersPresenter(
    private val params: BestPartnerScreen
): BasePresenter<BestPartnerView>() {

    fun onBack() = router?.exit()

    override fun attachView(view: BestPartnerView?) {
        super.attachView(view)
        viewState.showCowList(params.cowPairResultList.map { it.otherCow })
    }

    fun onCowClick(cow: Cow) {
        router?.navigateTo(
            CowCardScreen(
                cow = cow,
                nextAction = CowCardNextAction.NEXT,
                nextScreen = InstructionScreen(
                    subtitleRes = R.string.confirm_partner_screen_title,
                    buttonRes = R.string.search_by_tag_button_scan,
                    iconRes = R.drawable.tag,
                    nextAction = InstructionNextAction.NEXT,
                    nextScreen = ParameterSelectionScreen(cow.id)
                )
            )
        )
    }
}