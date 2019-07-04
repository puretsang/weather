package com.wai.coroutines.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.wai.coroutines.R
import com.wai.coroutines.adapter.FmPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val cities = arrayOf("北京", "上海", "深圳")
    private var fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        for (city in cities) {
            tabLayout.addTab(tabLayout.newTab().setText(city))
            fragments.add(CityFragment.newInstance(city))
        }
        tabLayout!!.setupWithViewPager(viewPager, false)
        val pagerAdapter = FmPagerAdapter(supportFragmentManager, fragments, cities)
        viewPager!!.adapter = pagerAdapter
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }


}
