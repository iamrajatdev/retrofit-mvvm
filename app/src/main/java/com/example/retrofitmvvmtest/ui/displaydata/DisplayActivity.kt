package com.example.retrofitmvvmtest.ui.displaydata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.retrofitmvvmtest.R

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        loadFragment(FirstFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragTransaction = fragmentManager.beginTransaction()
        fragTransaction.add(R.id.display_fragment, fragment).commit()
    }
}