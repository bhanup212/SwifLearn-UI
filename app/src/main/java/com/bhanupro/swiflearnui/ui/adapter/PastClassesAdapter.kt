package com.bhanupro.swiflearnui.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bhanupro.swiflearnui.R


/**
 * Created by Bhanu Prakash Pasupula on 16,Apr-2020.
 * Email: pasupula1995@gmail.com
 */
class PastClassesAdapter(val pastClasses:ArrayList<String>):RecyclerView.Adapter<PastClassesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PastClassesAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.past_clasess_row_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pastClasses.size
    }

    override fun onBindViewHolder(holder: PastClassesAdapter.ViewHolder, position: Int) {

    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}