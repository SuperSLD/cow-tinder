package com.example.app_ui.screens.best_partners

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.R
import com.example.app_ui.common.ARG_KEY_SCREEN_PARAMS
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.core.base.addSystemBottomPadding
import com.example.app_ui.common.core.base.addSystemTopPadding
import com.example.app_ui.common.view.simplerecycler.SimpleRecyclerAdapter
import com.example.app_ui.screens.holders.SearchCoupleViewHolder
import kotlinx.android.synthetic.main.fragment_cow_card.backArrow
import kotlinx.android.synthetic.main.fragment_search_couple.cowAdapter

class BestPartnersFragment: BaseFragment(R.layout.fragment_best_partners), BestPartnerView {

    @InjectPresenter
    lateinit var presenter: BestPartnersPresenter
    companion object {
        fun newInstance(screen: BestPartnerScreen) = BestPartnersFragment().apply {
            arguments = bundleOf(ARG_KEY_SCREEN_PARAMS to screen)
        }
    }

    @ProvidePresenter
    fun providePresenter() = BestPartnersPresenter(
        requireArguments().getSerializable(ARG_KEY_SCREEN_PARAMS) as BestPartnerScreen,
    )

    private val coupleAdapter by lazy {
        SimpleRecyclerAdapter(
            R.layout.view_item_cow,
            { SearchCoupleViewHolder(it) },
            { item, _ -> presenter.onCowClick(item) }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backArrow.setOnClickListener { onBackPressed() }
        backArrow.addSystemTopPadding()
        with(cowAdapter) {
            addSystemBottomPadding()
            adapter = coupleAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

    override fun showCowList(cowList: List<Cow>) {
        coupleAdapter.swapItems(cowList)
    }
}