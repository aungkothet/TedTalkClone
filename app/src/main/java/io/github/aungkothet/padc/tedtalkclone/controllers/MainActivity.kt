package io.github.aungkothet.padc.tedtalkclone.controllers

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.PopupMenu
import io.github.aungkothet.padc.tedtalkclone.R
import io.github.aungkothet.padc.tedtalkclone.adapters.TabPagerAdapter
import io.github.aungkothet.padc.tedtalkclone.delegates.TalkItemDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : TalkItemDelegate, AppCompatActivity() {

    override fun onItemClicked(speakerName: String, duration: String, talkTitle: String) {
        startActivity(TalkDetailActivity.newIntent(this, speakerName, duration, talkTitle))
    }

    override fun onMenuItemClicked(view: View, position: Int) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_item_popup, popupMenu.menu)
        popupMenu.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val tabPagerAdapter = TabPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = tabPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}