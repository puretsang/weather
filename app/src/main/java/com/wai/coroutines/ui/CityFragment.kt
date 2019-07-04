package com.wai.coroutines.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wai.coroutines.R
import kotlinx.android.synthetic.main.fragment_city.view.*

class CityFragment : Fragment() {

    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            val cityName = arguments!!.getString("city_key")
            rootView = inflater.inflate(R.layout.fragment_city, container,false)
            loadData()
            rootView!!.tvName.text = cityName
        }
        return rootView
    }

    private fun loadData() {
    }

    companion object {
        fun newInstance(city: String): Fragment {
            val arguments = Bundle()
            arguments.putString("city_key", city)
            val fragment = CityFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}