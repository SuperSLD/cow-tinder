package com.example.app_ui.screens.cowcard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.R
import com.example.app_ui.common.ARG_KEY_SCREEN_PARAMS
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemTopAndBottomPadding
import com.example.app_ui.common.core.base.addSystemTopPadding
import kotlinx.android.synthetic.main.fragment_cow_card.actionButton
import kotlinx.android.synthetic.main.fragment_cow_card.backArrow
import kotlinx.android.synthetic.main.fragment_cow_card.cowBirthday
import kotlinx.android.synthetic.main.fragment_cow_card.cowFertility
import kotlinx.android.synthetic.main.fragment_cow_card.cowGender
import kotlinx.android.synthetic.main.fragment_cow_card.cowHealth
import kotlinx.android.synthetic.main.fragment_cow_card.cowMilk
import kotlinx.android.synthetic.main.fragment_cow_card.cowNumber
import kotlinx.android.synthetic.main.fragment_cow_card.cowPoroda
import kotlinx.android.synthetic.main.fragment_cow_card.cowWeight
import kotlinx.android.synthetic.main.fragment_cow_card.mainContainer

class CowCardFragment : BaseFragment(R.layout.fragment_cow_card), CowCardView {

    companion object {
        fun newInstance(screen: CowCardScreen) = CowCardFragment().apply {
            arguments = bundleOf(ARG_KEY_SCREEN_PARAMS to screen)
        }
    }

    @InjectPresenter
    lateinit var presenter: CowCardPresenter

    @ProvidePresenter
    fun providePresenter() = CowCardPresenter(
        requireArguments().getSerializable(ARG_KEY_SCREEN_PARAMS) as CowCardScreen,
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainContainer.addSystemTopAndBottomPadding()
        backArrow.setOnClickListener { onBackPressed() }
        actionButton.setOnClickListener { presenter.onButtonClick() }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

    @SuppressLint("SetTextI18n")
    override fun showCow(cow: Cow) {
        cowNumber.text = cow.id
        cowGender.text = cow.sex
        cowPoroda.text = cow.breed
        cowWeight.text = cow.meatVolume
        cowMilk.text = cow.milkVolume + " л."
        cowHealth.text = cow.health
        cowFertility.text = cow.fertility + "%"
        cowBirthday.text = cow.birthDate
    }
}