package com.example.androidnetwordking.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidnetwordking.Retrofit.RetrofitApi
import com.example.androidnetwordking.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


        binding.txtSingUp.setOnClickListener {
            val intent = Intent(this@Login, SingUp::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {

            val textEmail = binding.editEmail.text.toString().trim()
            val password = binding.editTextPass.text.toString().trim()
            Login_Account(textEmail, password)


        }

    }

     fun Login_Account(textEmail: String, password: String) {
         val retrofit = Retrofit.Builder()
             .baseUrl("http://192.168.1.182:4000")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
//
         val apiService = retrofit.create(RetrofitApi::class.java)

         val call: Call<Void> = apiService.login( textEmail, password)





         call.enqueue(object : Callback<Void> {
             override fun onResponse(call: Call<Void>, response: Response<Void>) {
                 if (response.isSuccessful) {
                     val intent = Intent(this@Login, MainActivity::class.java)
                     startActivity(intent)
                     Toast.makeText(
                         this@Login,
                         "Thành công",
                         Toast.LENGTH_SHORT
                     ).show()
                 }else{
                     Toast.makeText(
                         this@Login,
                         "k ddee trong ",
                         Toast.LENGTH_SHORT).show()
                 }
             }

             override fun onFailure(call: Call<Void>, t: Throwable) {
                 Toast.makeText(
                     this@Login,
                     "Gửi dữ liệu thất bại: " + t.message,
                     Toast.LENGTH_SHORT
                 ).show()
             }
         })


     }

     }