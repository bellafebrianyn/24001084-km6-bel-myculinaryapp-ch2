package com.example.myculinaryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myculinaryapp.databinding.ItemMenuBinding
import com.example.myculinaryapp.model.Menu
import com.example.myculinaryapp.utils.toIndonesianFormat

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.CatalogViewHolder>() {

    private val data = mutableListOf<Menu>()

    fun submitData(items: List<Menu>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class CatalogViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Menu) {
            binding.ivCatalogImage.setImageResource(item.image)
            binding.tvCatalogName.text = item.name
            binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
        }
    }
}
