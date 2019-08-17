package io.github.aungkothet.padc.tedtalkclone.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.aungkothet.padc.tedtalkclone.R
import io.github.aungkothet.padc.tedtalkclone.delegates.TalkItemDelegate
import kotlinx.android.synthetic.main.talk_card_item.view.*
import java.util.*

class TalkItemHolder(itemView: View, private val itemClickDelegate: TalkItemDelegate)
    : RecyclerView.ViewHolder(itemView) {

    private val images =
            arrayListOf(R.drawable.talk1, R.drawable.talk2, R.drawable.talk3, R.drawable.talk4, R.drawable.talk5)

    private val speakers = arrayListOf("Sandra Aamodt", "Karim Abouelnaga", "OluTimehin Adegbeye",
            "Halima Aden", "Christoph Adami")

    private val talkTitles = arrayListOf("The Secret Of YOUTH",
            "How to use family dinner to teach polities",
            "Top 10 Tips With YOUTH",
            "How To Make Your YOUTH Look Amazing In 5 Days",
            "How To Start A Business")



    fun bindData(position: Int) {
        val random = Random().nextInt(images.size)
        val duration = "${Random().nextInt(60)}:${Random().nextInt(60)}"
        val speakerName = speakers[random]
        val talkTitle = talkTitles[random]
        itemView.img_talk.setImageResource(images[random])
        itemView.tv_speaker_name.text = speakerName
        itemView.tv_duration.text = duration
        itemView.tv_talk_title.text = talkTitle
        itemView.ib_popup_menu.setOnClickListener { view ->
            itemClickDelegate.onMenuItemClicked(view, position)
        }
        itemView.setOnClickListener { itemClickDelegate.onItemClicked(speakerName, duration, talkTitle) }
    }
}
