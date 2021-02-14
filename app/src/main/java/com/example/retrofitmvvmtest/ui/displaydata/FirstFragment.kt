package com.example.retrofitmvvmtest.ui.displaydata

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmtest.R
import com.example.retrofitmvvmtest.adapter.PageListAdapter
import com.example.retrofitmvvmtest.utils.Resource
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    private lateinit var viewModel: DisplayViewModel
    private var adapterPageListAdapter = PageListAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)
        viewModel.fetchPost(2)

        viewModel.loginResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar()
                }

                is Resource.Error -> {
                    hideProgressBar()
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

        viewModel.getPageResponse().observe(viewLifecycleOwner, {
            it?.let {
                Log.e("Data stored", "Successfully stored $it")
                adapterPageListAdapter.submitList(it.data)
                recyclerView.adapter = adapterPageListAdapter
            }
        })
        return view
    }

    private fun showProgressBar() {
        progress_circular.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progress_circular.visibility = View.GONE
    }
}