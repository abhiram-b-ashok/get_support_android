package com.example.myprogressbar.getsupport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myprogressbar.databinding.ReasonsRecyclerLayoutBinding

class Adapter(private val reasonList: List<Reasons>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ReasonsRecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return reasonList.size
    }


    class ViewHolder(binding: ReasonsRecyclerLayoutBinding) :RecyclerView.ViewHolder(binding.root){

    }
}