package com.wai.coroutines.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wai.coroutines.R
import com.wai.coroutines.pojo.WeatherData
import com.wai.coroutines.presenter.WeatherContract
import com.wai.coroutines.presenter.WeatherPresenter
import kotlinx.android.synthetic.main.fragment_city.view.*

class CityFragment : Fragment(), WeatherContract.View {
    override fun showLoadingView() {
        rootView!!.tvName.text = "====== 正在加载 ====="
    }

    override fun showLoadingSuccessView(data: WeatherData) {
        rootView!!.tvName.text = data.description
    }

    override fun showLoadingErrorView() {
        rootView!!.tvName.text = "====== 加载失败 ====="
    }

    private var rootView: View? = null
    private var presenter: WeatherPresenter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            presenter = WeatherPresenter()
            presenter!!.attachView(this)
            rootView = inflater.inflate(R.layout.fragment_city, container, false)
            loadData()
        }
        return rootView
    }

    private fun loadData() {
        val cityName = arguments!!.getString("city_key")
        presenter!!.retrofitCoroutine(cityName!!)
    }

    override fun onDestroyView() {
        presenter!!.detachView()
        super.onDestroyView()
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