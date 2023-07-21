package com.example.androidnetwordking.fra

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetwordking.Adapter.ProductAdapter
import com.example.androidnetwordking.Model.Product
import com.example.androidnetwordking.Model.productAge
import com.example.androidnetwordking.R
import com.example.androidnetwordking.Retrofit.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Home : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter
    var productList = ArrayList<Product>()


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_home_activity, container, false)
        recyclerView = view.findViewById(R.id.Recyclerview)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        showSp()
        return view;
    }

     fun showSp() {
        val retrofit =  Retrofit.Builder()
            .baseUrl("http://192.168.1.182:4000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitApi : RetrofitApi = retrofit.create(RetrofitApi::class.java)
        val call : Call<productAge> = retrofitApi.getAllProduct()

        call.enqueue(object  : Callback<productAge> {
            override fun onResponse(call: Call<productAge>, response: Response<productAge>) {
              if(response.isSuccessful){
                  productList = response.body()?.products as ArrayList<Product>
                  adapter = ProductAdapter(requireContext(),productList )
                  recyclerView.adapter = adapter
              }
                Log.d("aa", "aa"+productList.size)
                Toast.makeText(requireContext(),"thanh cong ", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<productAge>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })

    }



}