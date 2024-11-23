package com.example.app_ui.screens.success

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.app_ui.R
import com.example.app_ui.common.ARG_KEY_SCREEN_PARAMS
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemBottomPadding
import com.example.app_ui.ext.getDrawable
import kotlinx.android.synthetic.main.fragment_instruction.buttonsContainer
import kotlinx.android.synthetic.main.fragment_instruction.success_button
import kotlinx.android.synthetic.main.fragment_instruction.success_icon
import kotlinx.android.synthetic.main.fragment_instruction.success_subtitle

class InstructionFragment : BaseFragment(R.layout.fragment_instruction), InstructionView {

    companion object {
        fun newInstance(screen: InstructionScreen) = InstructionFragment().apply {
            arguments = bundleOf(ARG_KEY_SCREEN_PARAMS to screen)
        }
    }

    @InjectPresenter
    lateinit var presenter: InstructionPresenter

    @ProvidePresenter
    fun providePresenter() = InstructionPresenter(
        requireArguments().getSerializable(ARG_KEY_SCREEN_PARAMS) as InstructionScreen,
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonsContainer.addSystemBottomPadding()

        success_button.setOnClickListener {
            presenter.onConfirm()
        }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

    override fun setContent(subtitle: Int, icon: Int, buttonTitle: Int) {
        success_icon.setImageDrawable(getDrawable(icon))
        success_subtitle.setText(subtitle)
        success_button.setText(buttonTitle)
    }

}