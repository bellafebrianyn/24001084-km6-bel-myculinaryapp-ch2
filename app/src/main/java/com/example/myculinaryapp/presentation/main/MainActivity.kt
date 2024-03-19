package com.example.myculinaryapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myculinaryapp.R
import com.example.myculinaryapp.data.datasource.CategoryDataSource
import com.example.myculinaryapp.data.datasource.CategoryDataSourceImpl
import com.example.myculinaryapp.databinding.ActivityMainBinding
import com.example.myculinaryapp.presentation.categorylist.adapter.CategoryAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var categoryAdapter = CategoryAdapter()
    private val categoryDataSource: CategoryDataSource by lazy {
        CategoryDataSourceImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        changeProfileIcon()
        setAction()
        setListCategory()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setListCategory() {

        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter?.submitData(categoryDataSource.dataCategory())
    }

    private fun changeProfileIcon() {
        binding.layoutHeader.ivAppProfile.setImageResource(R.drawable.ic_girl)
    }

    private fun setAction() {
        binding.layoutHeader.ivAppProfile.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                getString(R.string.action_greetings), Toast.LENGTH_SHORT
            ).show()
        }
        binding.layoutHeader.tvGreetings.text = getString(R.string.action_name)
    }
}