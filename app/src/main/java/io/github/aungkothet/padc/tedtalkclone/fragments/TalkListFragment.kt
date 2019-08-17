package io.github.aungkothet.padc.tedtalkclone.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import io.github.aungkothet.padc.tedtalkclone.R
import io.github.aungkothet.padc.tedtalkclone.adapters.TalkListRecyclerAdapter
import io.github.aungkothet.padc.tedtalkclone.delegates.TalkItemDelegate
import kotlinx.android.synthetic.main.fragment_talk_list.view.*

class TalkListFragment : Fragment() {

    private lateinit var itemDelegate: TalkItemDelegate

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_talk_list, container, false)
        val talkListRecyclerAdapter = TalkListRecyclerAdapter(view.context, itemDelegate)
        val layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)
        view.talkListRecyclerView.layoutManager = layoutManager
        view.talkListRecyclerView.adapter = talkListRecyclerAdapter
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        itemDelegate = context as TalkItemDelegate
    }

}
