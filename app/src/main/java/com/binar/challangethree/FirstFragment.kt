package com.binar.challangethree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FirstFragment : Fragment() {
    private lateinit var toSecondFragmentButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toSecondFragmentButton = view.findViewById(R.id.to_second_button)

        toSecondFragmentButton.setOnClickListener {
            val fragmentManagaer: FragmentManager = parentFragmentManager
            val fragmentTrasaction: FragmentTransaction = fragmentManagaer.beginTransaction()
            val secondFragment = SecondFragment()
            fragmentTrasaction.replace(
                R.id.container_frame_layout,
                secondFragment,
                SecondFragment::class.java.simpleName
            )
            fragmentTrasaction.addToBackStack(null)
            fragmentTrasaction.commit()

        }

    }


}