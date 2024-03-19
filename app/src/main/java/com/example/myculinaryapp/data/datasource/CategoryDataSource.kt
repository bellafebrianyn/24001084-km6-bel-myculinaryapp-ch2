package com.example.myculinaryapp.data.datasource

import com.example.myculinaryapp.R
import com.example.myculinaryapp.data.model.Category

interface CategoryDataSource {
    fun dataCategory() : List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun dataCategory(): List<Category> {
        return mutableListOf(
            Category(
                image = R.drawable.img_nasi_lemak,
                name = "Nasi"
            ),
            Category(
                image = R.drawable.img_noodle,
                name = "Mie"
            ),
            Category(
                image = R.drawable.img_snack,
                name = "Snack"
            ),
            Category(
                image = R.drawable.img_beverage,
                name = "Minuman"
            ),
            Category(
                image = R.drawable.img_bread,
                name = "Roti"
            ),
        )
    }

}