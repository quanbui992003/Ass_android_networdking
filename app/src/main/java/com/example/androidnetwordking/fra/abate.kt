package com.example.androidnetwordking.fra

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.androidnetwordking.R
import com.example.androidnetwordking.databinding.FragmentAbateBinding


class abate : Fragment() {



    lateinit var binding: FragmentAbateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAbateBinding.inflate(inflater, container, false)
        val view = binding.root
        val image = arguments?.getString("image")
        val name = arguments?.getString("name")
        val price = arguments?.getString("price")

        Log.d("aaaa","aaa"+name)
        if (!name.isNullOrEmpty() && !price.isNullOrEmpty()) {
            binding.nameTt.text = name
            binding.priceTt.text = price
        }

        Glide.with(this)
            .load(image)
            .into(binding.imgTt)

        return view


    }


}