package com.example.app_ui.screens.searchbytag

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.app_ui.R
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemBottomPadding
import com.example.app_ui.common.core.base.addSystemTopPadding
import com.example.app_ui.ext.setVisible
import kotlinx.android.synthetic.main.fragment_search_by_tag.backArrow
import kotlinx.android.synthetic.main.fragment_search_by_tag.buttonsCard
import kotlinx.android.synthetic.main.fragment_search_by_tag.mainContainer
import kotlinx.android.synthetic.main.fragment_search_by_tag.progress
import kotlinx.android.synthetic.main.fragment_search_by_tag.searchScanButton
import kotlinx.android.synthetic.main.fragment_search_by_tag.searchTypeSwitch
import kotlinx.android.synthetic.main.fragment_search_by_tag.tagEditText
import kotlinx.android.synthetic.main.fragment_search_by_tag.textScan
import online.juter.supersld.view.input.selectors.JTHorizontalSwitch

class SearchByTagFragment : BaseFragment(R.layout.fragment_search_by_tag), SearchByTagView {

    @InjectPresenter
    lateinit var presenter: SearchByTagPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainContainer.addSystemTopPadding()
        buttonsCard.addSystemBottomPadding()
        backArrow.setOnClickListener { onBackPressed() }

        with(searchTypeSwitch) {
            init(
                tabs = listOf(getString(R.string.search_by_tag_id), getString(R.string.search_by_tag_rfid)),
                params = JTHorizontalSwitch.JTSwitchParams(
                    textColorDefault = "#FFFFFF",
                    textColorSelected = "#000000",
                    corners = 0,
                    borderColor = "#FFFFFF",
                    backColorSelected = "#FFFFFF",
                    backColor = "#00FFFFFF",
                )
            )
            onTabChanged {
                presenter.onChangeSearchType(it)
            }
        }

        searchScanButton.setOnClickListener {
            presenter.searchByTag(tagEditText.text.toString())
        }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

    override fun toggleLoading(show: Boolean) {
        progress.setVisible(show)
        searchScanButton.setVisible(!show)
    }

    override fun changeType(isTag: Boolean) {
        if (isTag) {
            tagEditText.setVisible(true)
            textScan.setText(R.string.search_by_tag_id_text)
            searchScanButton.setText(R.string.search_by_tag_button)
        } else {
            tagEditText.setVisible(false, View.INVISIBLE)
            textScan.setText(R.string.search_by_tag_rfid_text)
            searchScanButton.setText(R.string.search_by_tag_button_scan)
        }
    }
}