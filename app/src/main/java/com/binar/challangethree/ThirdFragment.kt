package com.binar.challangethree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class ThirdFragment : Fragment() {

    private lateinit var bottomNameTextView: TextView
    private lateinit var topNameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var jobTextView: TextView
    private lateinit var toScreenfourth: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNameTextView = view.findViewById(R.id.name_bottom_textView)
        topNameTextView = view.findViewById(R.id.name_top_textView)
        ageTextView = view.findViewById(R.id.age_textView)
        addressTextView = view.findViewById(R.id.address_textView)
        jobTextView = view.findViewById(R.id.job_textView)
        toScreenfourth = view.findViewById(R.id.to_fourth_button)

        //recive data from second fragment
        val nameResult = arguments?.getString("name_key")
        //show data from second fragment
        bottomNameTextView.text = nameResult

        toScreenfourth.setOnClickListener {
            val fragmentManagaer: FragmentManager = parentFragmentManager
            val fragmentTrasaction: FragmentTransaction = fragmentManagaer.beginTransaction()
            val fourthFragment = FourthFragment()

            val bundle = Bundle()
            bundle.putString("name", nameResult)
            fourthFragment.arguments = bundle
            fragmentTrasaction.replace(
                R.id.container_frame_layout,
                fourthFragment,
                fourthFragment::class.java.simpleName
            )
            fragmentTrasaction.addToBackStack(null)
            fragmentTrasaction.commit()
        }
         //get data from fourth fragment
        val firstPerson = arguments?.getParcelable<Person>("person_key")
        //show
        topNameTextView.text=firstPerson?.name
        ageTextView.text=firstPerson?.age
        addressTextView.text= firstPerson?.address
        jobTextView.text= firstPerson?.job
    }

}