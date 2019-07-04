package com.wai.coroutines.presenter

import com.orhanobut.logger.Logger
import com.wai.coroutines.base.BasePresenter
import com.wai.coroutines.model.repository.Repository
import kotlinx.coroutines.launch

class RecyclerPresenter : RecyclerContract.Presenter, BasePresenter<RecyclerContract.View>() {

    override fun retrofitCoroutine(type: Int, page: Int) {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val data = Repository.suspendList(type, page)
                view.showLoadingSuccessView(data)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Logger.d("============= 耗时：${System.currentTimeMillis() - time} ====================")
            }
        }
    }

}