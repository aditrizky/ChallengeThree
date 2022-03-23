package com.binar.challangethree

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class SecondFragment : Fragment() {
    private lateinit var inputNameEditText: EditText
    private lateinit var toThirdFragmentButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputNameEditText = view.findViewById(R.id.input_name_edit_text)
        toThirdFragmentButton = view.findViewById(R.id.to_third_button)

        toThirdFragmentButton.setOnClickListener {
            val fragmentManagaer: FragmentManager = parentFragmentManager
            val fragmentTrasaction: FragmentTransaction = fragmentManagaer.beginTransaction()
            val thirdFragment = ThirdFragment()
            val name = inputNameEditText.text
            fragmentTrasaction.replace(
                R.id.container_frame_layout,
                thirdFragment,
                thirdFragment::class.java.simpleName
            )
            //pasing and get data from edit text
            val bundle = Bundle()
            bundle.putString("name_key", name.toString())
            thirdFragment.arguments = bundle
            fragmentTrasaction.addToBackStack(null)
            // cek name required
            if (TextUtils.isEmpty(name)){
                Toast.makeText(requireActivity(),"Name Required", Toast.LENGTH_SHORT).show()
            }else {
                fragmentTrasaction.commit()
            }
        }

    }


}

