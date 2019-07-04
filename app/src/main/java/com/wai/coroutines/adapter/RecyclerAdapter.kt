package com.wai.coroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wai.coroutines.R
import com.wai.coroutines.pojo.SatinBean
import kotlinx.android.synthetic.main.item.view.*

class RecyclerAdapter(private val list: MutableList<SatinBean>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Holder(itemView)
    }

    fun notifyDataSetChanged(list: MutableList<SatinBean>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(list[position])
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(bean: SatinBean) {
            itemView.tvTitle.text = bean.name
            Glide.with(itemView).load(bean.image).into(itemView.imageView)
            itemView.tvCollection.text = bean.favourite.toString()
            itemView.tvLike.text = bean.love.toString()
            itemView.tvComment.text = bean.comment.toString()
            itemView.tvText.text = bean.text
            itemView.tvDate.text = "创建时间: ${bean.created_at}"
        }
    }
}