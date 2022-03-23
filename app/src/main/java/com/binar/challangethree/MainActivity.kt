package com.binar.challangethree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFirstFragment()
    }
    private fun openFirstFragment(){
        val fragmentManagaer: FragmentManager = supportFragmentManager
        val fragmentTrasaction: FragmentTransaction = fragmentManagaer.beginTransaction()
        val firstFragment= FirstFragment()
        fragmentTrasaction.add(R.id.container_frame_layout, firstFragment, FirstFragment::class.java.simpleName)
        fragmentTrasaction.commit()
    }
}