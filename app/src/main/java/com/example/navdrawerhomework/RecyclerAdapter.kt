package com.example.navdrawerhomework

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_item_recyclerview_layout.view.*

class RecyclerAdapter(private val items: MutableList<MenuModel>, private val activity: MainActivity, private val click: OnClick): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private var currentPosition = 0
    var selectedItem: Int=0

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private lateinit var item: MenuModel
        fun onbind(){
            item = items[adapterPosition]
            itemView.menuItemIcon.setImageResource(item.icon)
            itemView.menuItemText.text = item.title
            itemView.setBackgroundColor(ContextCompat.getColor(activity,android.R.color.white))

            if (selectedItem == adapterPosition) {
                itemView.setBackgroundColor(ContextCompat.getColor(activity,android.R.color.holo_blue_light))
            }

            itemView.setOnClickListener(){
                click.click(adapterPosition)
                selectedItem = adapterPosition
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.menu_item_recyclerview_layout, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind()
    }
}