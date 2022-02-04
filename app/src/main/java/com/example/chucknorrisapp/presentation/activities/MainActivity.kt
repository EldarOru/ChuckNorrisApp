package com.example.chucknorrisapp.presentation.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.databinding.ActivityMainBinding
import com.example.chucknorrisapp.databinding.WebFragmentBinding
import com.example.chucknorrisapp.presentation.fragments.*

class MainActivity : AppCompatActivity(), OnFragmentInteractionsListener {
    private lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        supportFragmentManager.beginTransaction()
            .replace(mainActivityBinding.mainContainer.id, MainFragment(), mainFragmentTag)
            .replace(mainActivityBinding.bottomContainer.id, BottomNavigationFragment())
            .commit()
    }

    override fun onChangeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(mainActivityBinding.mainContainer.id, fragment, tag)
            .commit()
    }

    override fun onAddBackStack(name: String, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(name)
            .replace(mainActivityBinding.mainContainer.id, fragment)
            .commit()
    }

    override fun onPopBackStack() {
        for(i in 0..supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }

    companion object{
        const val mainFragmentTag = "MAIN_FRAGMENT"
        const val webFragmentTag = "WEB_FRAGMENT"
    }
}