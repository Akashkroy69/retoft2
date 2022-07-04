package com.example.retrofithowtodoandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass() : RecyclerView.Adapter<AdapterClass.ViewHolderForDataItemsInRV>() {

    var dataSet = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolderForDataItemsInRV(private val rootView: TextView) :
        RecyclerView.ViewHolder(rootView) {
        companion object {
            fun inflateFrom(parent: ViewGroup): ViewHolderForDataItemsInRV {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.movie_item, parent, false)
                return ViewHolderForDataItemsInRV(view as TextView)
            }

        }

        fun bind(item : Movie){
            rootView.text = item.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForDataItemsInRV =
        ViewHolderForDataItemsInRV.inflateFrom(parent)

    override fun onBindViewHolder(holder: ViewHolderForDataItemsInRV, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}