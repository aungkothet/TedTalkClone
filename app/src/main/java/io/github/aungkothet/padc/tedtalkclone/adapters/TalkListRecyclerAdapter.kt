package io.github.aungkothet.padc.tedtalkclone.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.tedtalkclone.R
import io.github.aungkothet.padc.tedtalkclone.delegates.TalkItemDelegate
import io.github.aungkothet.padc.tedtalkclone.viewholders.TalkItemHolder
import kotlinx.android.synthetic.main.talk_card_item.view.*
import java.util.*

class TalkListRecyclerAdapter(private val context: Context, private val itemClickDelegate: TalkItemDelegate)
    : RecyclerView.Adapter<TalkItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TalkItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.talk_card_item, parent, false)
        return TalkItemHolder(view, itemClickDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(viewHolder: TalkItemHolder, position: Int) {
        viewHolder.bindData(position)
    }

}