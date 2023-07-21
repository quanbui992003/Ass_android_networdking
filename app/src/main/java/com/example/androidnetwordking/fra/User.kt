package com.example.androidnetwordking.fra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.example.androidnetwordking.R
import androidx.appcompat.app.AppCompatActivity

class User : Fragment() {

   lateinit var toolbar :Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar2)
        toolbar.setTitle("Chọn sản phẩm");

        val actionBar = requireActivity().actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_arrow_left_24)

        return view;
    }


}