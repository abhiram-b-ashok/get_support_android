package com.example.myprogressbar.getsupport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myprogressbar.R
import com.example.myprogressbar.databinding.ReasonsRecyclerLayoutBinding

class Adapter(private val reasonList: List<Reasons>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    var onItemClicked: ((Reasons) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ReasonsRecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reasonList[position],onItemClicked)

    }

    override fun getItemCount(): Int {
        return reasonList.size
    }

    class ViewHolder(private val binding: ReasonsRecyclerLayoutBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(reason: Reasons, onItemClicked: ((Reasons) -> Unit)?=null) {
            binding.apply {
                reasonText.text = reason.reasons
                root.setOnClickListener {
                    onItemClicked?.invoke(reason)
                }

            }

        }
    }
}