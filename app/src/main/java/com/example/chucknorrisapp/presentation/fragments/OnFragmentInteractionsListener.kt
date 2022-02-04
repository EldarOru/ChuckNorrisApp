package com.example.chucknorrisapp.presentation.fragments

import androidx.fragment.app.Fragment

interface OnFragmentInteractionsListener {

    fun onChangeFragment(fragment: Fragment, tag: String)

    fun onAddBackStack(name: String, fragment: Fragment)

    fun onPopBackStack()

}