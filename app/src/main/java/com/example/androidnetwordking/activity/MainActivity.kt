package com.example.androidnetwordking.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidnetwordking.R
import com.example.androidnetwordking.databinding.ActivityMainBinding
import com.example.androidnetwordking.fra.Home
import com.example.androidnetwordking.fra.Shopping
import com.example.androidnetwordking.fra.User

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,Home() )
                .commit();
        }
        binding.bottom.setOnItemReselectedListener {item ->

            when(item.itemId){
                R.id.Home ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container,Home() )
                        .commit();
                    true
                }
                R.id.shopping_cart ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container,Shopping() )
                        .commit();
                    true
                }
                R.id.person ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container,User() )
                        .commit();
                    true
                }
                else -> false
            }
        }

    }


}