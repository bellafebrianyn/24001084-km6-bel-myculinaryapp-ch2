package com.example.myculinaryapp.presentation.menulist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myculinaryapp.base.ViewHolderBinder
import com.example.myculinaryapp.data.model.Menu
import com.example.myculinaryapp.databinding.ItemMenuBinding
import com.example.myculinaryapp.utils.toIndonesianFormat

class MenuGridItemViewHolder(
    private val binding: ItemMenuBinding,
    private val listener: OnItemClickedListener<Menu>
) : ViewHolder(binding.root), ViewHolderBinder<Menu> {
    override fun bind(item: Menu) {
        item.let {
            binding.ivMenuImage.setImageResource(item.image)
            binding.tvMenuName.text = item.name
            binding.tvMenuPrice.text = item.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}