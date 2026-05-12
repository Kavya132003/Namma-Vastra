package com.example.namma_vastra.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.R
import com.example.namma_vastra.models.Product

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.productName.text = product.name
        holder.productPrice.text = product.price
    }

    override fun getItemCount(): Int {

        return productList.size
    }
}