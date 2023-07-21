package com.example.androidnetwordking.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidnetwordking.R
import com.example.androidnetwordking.Retrofit.RetrofitApi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SingUp : AppCompatActivity() {

    lateinit var email :EditText
    lateinit var userName :EditText
    lateinit var passWord : EditText
    lateinit var userPhone : EditText
    lateinit var btnSingUp :Button

    val client = OkHttpClient()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        email = findViewById(R.id.sing_up_email)
        userName = findViewById(R.id.sing_up_userName)
        passWord = findViewById(R.id.sing_up_password)
        userPhone = findViewById(R.id.sing_up_userPhone)
        btnSingUp = findViewById(R.id.btn_SingUp)


        btnSingUp.setOnClickListener {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.182:4000")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(RetrofitApi::class.java)

            val textEmail = email.text.toString().trim()
            val password = passWord.text.toString().trim()
            val name = userName.text.toString().trim()
            val phone = userPhone.text.toString().trim()


//                val emailRequestBody = RequestBody.create("text/plain".toMediaTypeOrNull(),textEmail )
//                // val userNameRequestBody = RequestBody.create("text/plain".toMediaTypeOrNull(), userName)
//                val passwordRequestBody = RequestBody.create("text/plain".toMediaTypeOrNull(), password)
//

                val call: Call<Void> = apiService.sendText(
                    textEmail,
                    password,
                    name,
                    phone
                    )
                call.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@SingUp,
                                "Data sent successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(this@SingUp,Login::class.java))
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(
                            this@SingUp,
                            "Failed to send data: " + t.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

            }

        }

}