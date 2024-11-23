package com.example.app_ui.screens.home

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.app_ui.R
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemTopPadding
import kotlinx.android.synthetic.main.fragment_home.cow_info
import kotlinx.android.synthetic.main.fragment_home.cow_inventory
import kotlinx.android.synthetic.main.fragment_home.cow_sex
import kotlinx.android.synthetic.main.fragment_home.mainCard
import kotlinx.android.synthetic.main.fragment_home.name
import kotlinx.android.synthetic.main.fragment_home.new_cow

class HomeFragment : BaseFragment(R.layout.fragment_home), HomeView {

    @InjectPresenter
    lateinit var presenter: HomePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainCard.addSystemTopPadding()
        name.text = "Воронцов Юрий"

        new_cow.setOnClickListener { presenter.onOpenNewCowProcess() }
        cow_info.setOnClickListener { presenter.onOpenCowInfoProcess() }
        cow_sex.setOnClickListener { presenter.onOpenCowSexProcess() }
        cow_inventory.setOnClickListener { presenter.onOpenCowInventoryProcess() }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }
}