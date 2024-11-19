package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)

        // Find the button and set its click listener
        val button: Button = view.findViewById(R.id.button_send)
        button.setOnClickListener {
            (activity as? MainActivity)?.sendDataToFragment2("Hello from MyFragment")
        }

        return view
    }
}