package com.example.app_ui.screens.search_couple

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.R
import com.example.app_ui.common.core.base.BaseFragment
import com.example.app_ui.common.view.simplerecycler.SimpleRecyclerAdapter
import com.example.app_ui.ext.setVisible
import com.example.app_ui.ext.textChanged
import com.example.app_ui.screens.holders.SearchCoupleViewHolder
import kotlinx.android.synthetic.main.fragment_search_couple.cowAdapter
import kotlinx.android.synthetic.main.fragment_search_couple.cow_id_et
import kotlinx.android.synthetic.main.fragment_search_couple.cow_list_container
import kotlinx.android.synthetic.main.fragment_search_couple.cow_list_loading
import kotlinx.android.synthetic.main.fragment_search_couple.toolbar

class SearchCoupleFragment: BaseFragment(R.layout.fragment_search_couple), SearchCoupleView {

    @InjectPresenter
    lateinit var presenter: SearchCouplePresenter

    private val coupleAdapter by lazy {
        SimpleRecyclerAdapter(
            R.layout.view_item_cow,
            { SearchCoupleViewHolder(it) },
            { item, _ -> presenter.onCowClick(item) }
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.init(
            title = getString(R.string.search_couple_title),
            back = this::onBackPressed
        )

        cow_id_et.textChanged {

        }

        with(cowAdapter) {
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

    override fun toggleLoading(show: Boolean) {
        cow_list_loading.setVisible(show)
        cow_list_container.setVisible(!show)
    }
}