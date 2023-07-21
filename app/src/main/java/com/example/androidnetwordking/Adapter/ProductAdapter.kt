package com.example.androidnetwordking.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.androidnetwordking.Model.Product
import com.example.androidnetwordking.R
import com.example.androidnetwordking.databinding.ProductItemBinding
import com.example.androidnetwordking.fra.abate

class ProductAdapter(private val context : Context,var ProductList: ArrayList<Product>  ) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(var binding: ProductItemBinding )
            : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val binding= ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ProductViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {


            val imageUrl = ProductList[position].image
            Glide.with(holder.itemView.context)
                .load(imageUrl)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(holder.binding.spImage)
            holder.binding.spName.text=ProductList[position].name.toString()
            holder.binding.spPrice.text=ProductList[position].price.toString()
            holder.binding.LinerLayout.setOnClickListener {
                val args = Bundle()
                val abate = abate()
                args.putString("image", ProductList.get(holder.adapterPosition).image)
                args.putString("name", ProductList.get(holder.adapterPosition).name)
                args.putString("price", ProductList.get(holder.adapterPosition).price.toString())
                abate.arguments = args
                val fragmentManager = (context as AppCompatActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.main_container,abate)
                    .addToBackStack(null)
                    .commit()
            }
        }

        override fun getItemCount(): Int {
            return ProductList.size
        }
}