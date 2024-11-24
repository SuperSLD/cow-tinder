package com.example.app_ui.screens.parameter_selection

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.app_ui.R
import com.example.app_ui.common.ARG_KEY_SCREEN_PARAMS
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemTopPadding
import com.example.app_ui.screens.cowcard.CowCardFragment
import kotlinx.android.synthetic.main.fragment_cow_card.backArrow
import kotlinx.android.synthetic.main.fragment_parameter_selection.selectParameterSwitch
import kotlinx.android.synthetic.main.fragment_search_by_tag.mainContainer
import online.juter.supersld.view.input.selectors.JTHorizontalSwitch

class ParameterSelectionFragment: BaseFragment(R.layout.fragment_parameter_selection), ParameterSelectionView {

    companion object {
        fun newInstance(screen: ParameterSelectionScreen) = ParameterSelectionFragment().apply {
            arguments = bundleOf(ARG_KEY_SCREEN_PARAMS to screen)
        }
    }

    @ProvidePresenter
    fun providePresenter() = ParameterSelectionPresenter(
        requireArguments().getSerializable(ARG_KEY_SCREEN_PARAMS) as ParameterSelectionScreen,
    )

    @InjectPresenter
    lateinit var presenter: ParameterSelectionPresenter
    override fun onBackPressed() {
        presenter.onBack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainContainer.addSystemTopPadding()
        backArrow.setOnClickListener { onBackPressed() }

        with(selectParameterSwitch) {
            init(
                tabs = listOf(
                    getString(R.string.parameter_selection_milkVolume),
                    getString(R.string.parameter_selection_mass),
                    getString(R.string.parameter_selection_health)
                ),
                params = JTHorizontalSwitch.JTSwitchParams(
                    textColorDefault = "#000000",
                    textColorSelected = "#FFFFFF",
                    corners = 0,
                    borderColor = "#000000",
                    backColorSelected = "#000000",
                    backColor = "#00FFFFFF",
                )
            )
            onTabChanged {
                presenter.onMainParameterChange(it)
            }
        }
    }
}