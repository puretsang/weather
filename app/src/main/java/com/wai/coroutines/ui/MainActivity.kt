package com.wai.coroutines.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wai.coroutines.BaseConfig
import com.wai.coroutines.R
import com.wai.coroutines.adapter.FmPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private var fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        for (city in BaseConfig.cities) {
            tabLayout.addTab(tabLayout.newTab().setText(city))
            fragments.add(CityFragment.newInstance(city))
        }
        tabLayout!!.setupWithViewPager(viewPager, false)
        val pagerAdapter = FmPagerAdapter(supportFragmentManager, fragments, BaseConfig.cities)
        viewPager!!.adapter = pagerAdapter
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecycleActivity::class.java))
        }
    }


}
