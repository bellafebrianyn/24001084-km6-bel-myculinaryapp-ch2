package com.example.myculinaryapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myculinaryapp.databinding.ActivityMainBinding
import com.example.myculinaryapp.model.Category
import com.example.myculinaryapp.model.Menu

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val categoryAdapter = CategoryAdapter()

    private val menuAdapter = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeProfileIcon()
        setAction()
        setListCategory()
        setListCatalog()
    }

    private fun setListCategory() {
        val dataCategory = listOf(
            Category(image = R.drawable.img_nasi_lemak, name = "Nasi"),
            Category(image = R.drawable.img_noodle, name = "Mie"),
            Category(image = R.drawable.img_snack, name = "Snack"),
            Category(image = R.drawable.img_beverage, name = "Minuman"),
            Category(image = R.drawable.img_bread, name = "Roti"),
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(dataCategory)
    }

    private fun setListCatalog() {
        val dataMenus = listOf(
            Menu(image = R.drawable.img_ayam_bakar, name = "Ayam Bakar", price = 18000.0),
            Menu(image = R.drawable.img_ayam_geprek, name = "Ayam Geprek", price = 15000.0),
            Menu(image = R.drawable.img_nasi_goreng, name = "Nasi Goreng", price = 15000.0),
            Menu(image = R.drawable.img_roti_bakar, name = "Roti Bakar", price = 12000.0),
            Menu(image = R.drawable.img_ayam_goreng, name = "Ayam Bakar", price = 17000.0),
            Menu(image = R.drawable.img_ayam_opor, name = "Ayam Opor", price = 16000.0),
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.menuAdapter
        }
        menuAdapter.submitData(dataMenus)
    }

    private fun changeProfileIcon() {
        binding.layoutHeader.ivAppProfile.setImageResource(R.drawable.ic_girl)
    }

    private fun setAction() {
        binding.layoutHeader.ivAppProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hallo", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvGreetings.text = "Hai, Bella!"
    }
}