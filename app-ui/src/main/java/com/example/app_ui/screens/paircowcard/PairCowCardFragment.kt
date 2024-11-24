package com.example.app_ui.screens.paircowcard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.app_domain.models.cow.CowPairResult
import com.example.app_ui.R
import com.example.app_ui.common.ARG_KEY_SCREEN_PARAMS
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemTopAndBottomPadding
import kotlinx.android.synthetic.main.fragment_pair_cow_card.actionButton
import kotlinx.android.synthetic.main.fragment_pair_cow_card.backArrow
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowBirthday
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowFertility
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowFertility2
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowGender
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowHealth
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowHealth2
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowMilk
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowMilk2
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowNumber
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowPoroda
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowWeight
import kotlinx.android.synthetic.main.fragment_pair_cow_card.cowWeight2
import kotlinx.android.synthetic.main.fragment_pair_cow_card.mainContainer

class PairCowCardFragment : BaseFragment(R.layout.fragment_pair_cow_card), PairCowCardView {

    companion object {
        fun newInstance(screen: PairCowCardScreen) = PairCowCardFragment().apply {
            arguments = bundleOf(ARG_KEY_SCREEN_PARAMS to screen)
        }
    }

    @InjectPresenter
    lateinit var presenter: PairCowCardPresenter

    @ProvidePresenter
    fun providePresenter() = PairCowCardPresenter(
        requireArguments().getSerializable(ARG_KEY_SCREEN_PARAMS) as PairCowCardScreen,
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
    override fun showCow(cowPairResult: CowPairResult) {
        with(cowPairResult.otherCow) {
            cowNumber.text = id
            cowGender.text = sex
            cowPoroda.text = breed
            cowWeight.text = meatVolume
            cowMilk.text = if (milkVolume.isBlank()) "---" else "$milkVolume л."
            cowHealth.text = health
            cowFertility.text = "$fertility%"
            cowBirthday.text = birthDate
        }
        with(cowPairResult.waitedCowData) {
            cowWeight2.text = weight.toString()
            cowMilk2.text = if (milk.toString().isBlank()) "---" else "$milk л."
            cowHealth2.text = health.toString()
            cowFertility2.text = "$fertility%"
        }
    }
}