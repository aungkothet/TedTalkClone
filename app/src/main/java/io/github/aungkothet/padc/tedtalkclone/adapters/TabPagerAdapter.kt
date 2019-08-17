package io.github.aungkothet.padc.tedtalkclone.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.github.aungkothet.padc.tedtalkclone.fragments.TalkListFragment

class TabPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        return TalkListFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Newest"
            1 -> "Trending"
            else -> "Most viewed"
        }
    }
}