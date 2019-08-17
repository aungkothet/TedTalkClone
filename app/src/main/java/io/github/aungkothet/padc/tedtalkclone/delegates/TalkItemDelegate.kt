package io.github.aungkothet.padc.tedtalkclone.delegates

import android.view.View

interface TalkItemDelegate {
    fun onItemClicked(speakerName: String, duration: String, talkTitle: String)

    fun onMenuItemClicked(view:View, position: Int)
}