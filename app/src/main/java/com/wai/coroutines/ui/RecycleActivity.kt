package com.wai.coroutines.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wai.coroutines.R
import com.wai.coroutines.adapter.RecyclerAdapter
import com.wai.coroutines.pojo.SatinBean
import com.wai.coroutines.presenter.RecyclerContract
import com.wai.coroutines.presenter.RecyclerPresenter
import com.wai.coroutines.utils.ToastShow
import kotlinx.android.synthetic.main.activity_recycle.*
import kotlinx.android.synthetic.main.recycler.*

class RecycleActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener, RecyclerContract.View {


    private var presenter: RecyclerPresenter? = null
    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        presenter = RecyclerPresenter()
        presenter!!.attachView(this)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        refreshLayout.setColorSchemeResources(
            R.color.colorPrimary,
            R.color.colorAccent,
            R.color.colorPrimaryDark
        )
        loadData()
    }

    private fun loadData() {
        presenter!!.retrofitCoroutine(1,1)
    }

    override fun onRefresh() {
        loadData()
    }


    override fun showLoadingSuccessView(data: MutableList<SatinBean>?) {
        hideRefreshLoading()
        if (data != null) {
            if (adapter == null) {
                adapter = RecyclerAdapter(data)
                recyclerView.adapter = adapter
            } else {
                adapter!!.notifyDataSetChanged(data)
            }
        } else {
            hideRefreshLoading()
            ToastShow.showToast("加载数据错误")
        }
    }

    override fun showLoadingView() {
        refreshLayout.isRefreshing = true
    }

    override fun showLoadingErrorView() {
        hideRefreshLoading()
        ToastShow.showToast("加载失败")
    }

    private fun hideRefreshLoading() {
        if (refreshLayout.isRefreshing) {
            refreshLayout.isRefreshing = false
        }
    }

    override fun onDestroy() {
        presenter!!.detachView()
        super.onDestroy()
    }

}