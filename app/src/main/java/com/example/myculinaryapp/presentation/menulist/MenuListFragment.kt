package com.example.myculinaryapp.presentation.menulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myculinaryapp.R
import com.example.myculinaryapp.data.datasource.MenuDataSource
import com.example.myculinaryapp.data.datasource.MenuDataSourceImpl
import com.example.myculinaryapp.data.model.Menu
import com.example.myculinaryapp.databinding.FragmentMenuListBinding
import com.example.myculinaryapp.presentation.menudetail.DetailActivity
import com.example.myculinaryapp.presentation.menulist.adapter.MenuAdapter
import com.example.myculinaryapp.presentation.menulist.adapter.OnItemClickedListener

class MenuListFragment : Fragment() {

    private lateinit var binding: FragmentMenuListBinding
    private var adapter: MenuAdapter? = null
    private val dataSource: MenuDataSource by lazy {
        MenuDataSourceImpl()
    }
    private var isUsingGridMode: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindMenuList(true)
        setClickAction()
    }

    private fun setClickAction() {
        binding.ivChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setIcon(isUsingGridMode)
            bindMenuList(isUsingGridMode)
        }
    }

    private fun setIcon(usingGridMode: Boolean) {
        binding.ivChangeListMode.setImageResource(if (usingGridMode) R.drawable.ic_list else R.drawable.ic_grid)
    }

    private fun bindMenuList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) MenuAdapter.MODE_GRID else MenuAdapter.MODE_LIST
        adapter =
            MenuAdapter(
                listMode = listMode,
                listener = object : OnItemClickedListener<Menu> {
                    override fun onItemClicked(item: Menu) {
                        navigateToDetail(item)
                    }

                })
        binding.rvMenuList.apply {
            adapter = this@MenuListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getMenuList())
    }

    private fun navigateToDetail(item: Menu) {
        DetailActivity.startActivity(requireContext(), item)
    }
}