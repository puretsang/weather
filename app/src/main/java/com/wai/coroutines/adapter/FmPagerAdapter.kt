package com.wai.coroutines.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FmPagerAdapter : FragmentStatePagerAdapter {

    private var fms: List<Fragment>? = null
    private var titles: Array<String>? = null

    constructor(fm: FragmentManager?, fms: List<Fragment>, titles: Array<String>) : super(fm) {
        this.fms = fms
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment {
        return fms!![position]
    }

    override fun getCount(): Int {
        return fms!!.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (titles != null) titles!![position] else super.getPageTitle(position)
    }
}