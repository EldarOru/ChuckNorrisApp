package com.example.chucknorrisapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisapp.data.RepositoryImpl
import com.example.chucknorrisapp.databinding.MainFragmentBinding
import com.example.chucknorrisapp.presentation.adapters.JokesListAdapter
import com.example.chucknorrisapp.presentation.viewmodels.MainFragmentViewModel
import com.example.chucknorrisapp.presentation.viewmodels.ViewModelFactory

class MainFragment: Fragment() {
    private lateinit var mainFragmentBinding: MainFragmentBinding
    private lateinit var jokesListAdapter: JokesListAdapter
    private lateinit var mainFragmentViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainFragmentViewModel = ViewModelProvider(this, ViewModelFactory(RepositoryImpl)).get(MainFragmentViewModel::class.java)
        setRecyclerView()

        mainFragmentBinding.reloadButton.setOnClickListener {
            mainFragmentViewModel.getJokes(mainFragmentBinding.jokesEt.text.toString())
        }

        mainFragmentViewModel.jokesLiveData.observe(viewLifecycleOwner){
            jokesListAdapter.list = it.value
        }
    }

    private fun setRecyclerView(){
        val recyclerView = mainFragmentBinding.jokesRv
        recyclerView.layoutManager = LinearLayoutManager(context)
        jokesListAdapter = JokesListAdapter()
        recyclerView.adapter = jokesListAdapter
        //jokesListAdapter.list = mainFragmentViewModel.jokesLiveData.value!!.value

    }
}