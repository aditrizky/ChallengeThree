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


class FourthFragment : Fragment() {
    private lateinit var ageEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var jobEditText: EditText
    private lateinit var backThreeButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ageEditText = view.findViewById(R.id.input_age_edit_text)
        addressEditText = view.findViewById(R.id.input_address_edit_text)
        jobEditText = view.findViewById(R.id.input_job_edit_text)
        backThreeButton = view.findViewById(R.id.back_to_third_button)

        backThreeButton.setOnClickListener {
            val fragmentManagaer: FragmentManager = parentFragmentManager
            val fragmentTrasaction: FragmentTransaction = fragmentManagaer.beginTransaction()
            val thirdFragment = ThirdFragment()
            fragmentTrasaction.replace(
                R.id.container_frame_layout,
                thirdFragment,
                thirdFragment::class.java.simpleName
            )
            //pasing and get data from edit text
            val bundle = Bundle()
            val firstPerson = Person(
                name = arguments?.getString("name").toString(),
                age = ageEditText.text.toString().trim(),
                address = addressEditText.text.toString().trim(),
                job = jobEditText.text.toString().trim()
            )
            //cek age requires (force close hendle)
            if (TextUtils.isEmpty(firstPerson.age)) {
                Toast.makeText(requireActivity(), "Age Requires", Toast.LENGTH_SHORT).show()
            } else {
                if (firstPerson.age.toInt() % 2 == 0) {
                    firstPerson.age = "${firstPerson.age}, bernilai Genap"
                } else {
                    firstPerson.age = "${firstPerson.age}, bernilai Ganjil"
                }
                bundle.putParcelable("person_key", firstPerson)
                thirdFragment.arguments = bundle
                fragmentTrasaction.addToBackStack(null)
                fragmentTrasaction.commit()
            }

        }

    }


}