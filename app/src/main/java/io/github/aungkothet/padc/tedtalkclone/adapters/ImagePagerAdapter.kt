package io.github.aungkothet.padc.tedtalkclone.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.github.aungkothet.padc.tedtalkclone.fragments.DetailImageFragment

class ImagePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return DetailImageFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 5
    }
}