package com.example.app_ui.screens.holders

import android.view.View
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.common.view.simplerecycler.SimpleViewHolder
import kotlinx.android.synthetic.main.view_item_cow.view.cowCard
import kotlinx.android.synthetic.main.view_item_cow.view.tvCowSex
import kotlinx.android.synthetic.main.view_item_cow.view.twCowBreed
import kotlinx.android.synthetic.main.view_item_cow.view.twCowId

class SearchCoupleViewHolder(containerView: View): SimpleViewHolder<Cow>(containerView) {
    override fun bindTo(item: Cow, pos: Int, onClickCallback: ((Cow, Int) -> Unit)?) {
        with(containerView) {

            cowCard.setOnClickListener { onClickCallback?.invoke(item, pos) }
            twCowId.text = item.id
            tvCowSex.text = item.sex
            twCowBreed.text = item.breed
        }
    }
}