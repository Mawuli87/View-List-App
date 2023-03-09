package com.yawomessie.view_list_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.yawomessie.view_list_app.R
import com.yawomessie.view_list_app.databinding.ItemDeveloperBinding
import com.yawomessie.view_list_app.models.DeveLoper

class DeveloperAdapter  constructor(private val context: Context) : BaseAdapter() {
   var developers = arrayListOf<DeveLoper>()

    override fun getCount(): Int {
       return developers.size
    }

    override fun getItem(position: Int): Any  = developers[position]


    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_developer, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as DeveLoper
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder(view: View) {
        private val binding = ItemDeveloperBinding.bind(view)

        fun bind(developer: DeveLoper) {
            binding.tvName.text = developer.name
            binding.tvDescription.text = developer.description
            binding.imgPhoto.setImageResource(developer.photo)
        }
    }
}