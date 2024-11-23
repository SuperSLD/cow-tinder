package com.example.app_ui.screens.auth.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.app_ui.R
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.ext.setVisible
import com.example.app_ui.ext.textChanged
import kotlinx.android.synthetic.main.fragment_login.login_button
import kotlinx.android.synthetic.main.fragment_login.login_content
import kotlinx.android.synthetic.main.fragment_login.login_edit_text
import kotlinx.android.synthetic.main.fragment_login.login_pb
import kotlinx.android.synthetic.main.fragment_login.password_edit_text

class LoginFragment : BaseFragment(R.layout.fragment_login), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isLoginNotEmpty = false
        var isPasswordNotEmpty = false

        login_edit_text.textChanged {
            isLoginNotEmpty = it.isNotEmpty()
            login_button.isEnabled = isLoginNotEmpty && isPasswordNotEmpty
        }

        password_edit_text.textChanged {
            isPasswordNotEmpty = it.isNotEmpty()
            login_button.isEnabled = isLoginNotEmpty && isPasswordNotEmpty
        }

        login_button.setOnClickListener {
            presenter.onLogin(
                login_edit_text.text.toString(),
                password_edit_text.text.toString()
            )
        }
    }

    override fun toggleLoading(isShow: Boolean) {
        login_content.setVisible(!isShow)
        login_pb.setVisible(isShow)
    }

    override fun showErrorToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        presenter.onBack()
    }
}