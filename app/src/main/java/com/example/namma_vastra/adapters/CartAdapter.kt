package com.example.namma_vastra.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namma_vastra.Product
import com.example.namma_vastra.R

class CartAdapter(
    private val cartList: ArrayList<Product>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val cartImage: ImageView =
            itemView.findViewById(R.id.cartImage)

        val cartName: TextView =
            itemView.findViewById(R.id.cartName)

        val cartPrice: TextView =
            itemView.findViewById(R.id.cartPrice)

        val cartQuantity: TextView =
            itemView.findViewById(R.id.cartQuantity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)

        return CartViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {

        val product = cartList[position]

        holder.cartName.text = product.name

        holder.cartPrice.text = product.price

        holder.cartQuantity.text =
            "Quantity: ${product.quantity}"

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.cartImage)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}