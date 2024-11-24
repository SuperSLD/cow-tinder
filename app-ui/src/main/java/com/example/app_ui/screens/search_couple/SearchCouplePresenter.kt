package com.example.app_ui.screens.search_couple

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.Cow
import com.example.app_domain.usecases.cow.GetAllCowsUseCase
import com.example.app_ui.R
import com.example.app_ui.common.core.base.launchUI
import com.example.app_ui.common.core.base.withIO
import com.example.app_ui.ext.createEmptyHandler
import com.example.app_ui.screens.cowcard.CowCardNextAction
import com.example.app_ui.screens.cowcard.CowCardScreen
import com.example.app_ui.screens.parameter_selection.ParameterSelectionScreen
import com.example.app_ui.screens.success.InstructionNextAction
import com.example.app_ui.screens.success.InstructionScreen
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class SearchCouplePresenter: BasePresenter<SearchCoupleView>() {

    private val getAllCowsUseCase: GetAllCowsUseCase by inject()
    private var cowList: List<Cow> = listOf()

    private var filter = ""

    fun onBack() = router?.exit()

    override fun attachView(view: SearchCoupleView?) {
        super.attachView(view)
        loadContent()
    }

    private fun loadContent() {
        launchUI(createEmptyHandler()) {
            viewState.toggleLoading(true)
            cowList = withIO { getAllCowsUseCase() }
            viewState.showCowList(cowList)
            viewState.toggleLoading(false)
        }
    }

    fun onFilterUpdate(filter: String) {
        this.filter = filter
        launchUI {
            if (filter.isNotBlank()) {
                val filteredList = withIO {
                    cowList.filter { it.id.contains(filter) }
                }
                viewState.showCowList(filteredList)
            } else {
                viewState.showCowList(cowList)
            }
        }
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