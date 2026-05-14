package com.example.namma_vastra.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namma_vastra.Product
import com.example.namma_vastra.ProductDetailsActivity
import com.example.namma_vastra.R

class ProductAdapter(
    private val productList: ArrayList<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val nameText: TextView =
            itemView.findViewById(R.id.productName)

        val priceText: TextView =
            itemView.findViewById(R.id.productPrice)

        val productImage: ImageView =
            itemView.findViewById(R.id.productImage)

        val buyButton: Button =
            itemView.findViewById(R.id.buyButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = productList[position]

        holder.nameText.text = product.name

        holder.priceText.text = product.price

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.productImage)

        holder.buyButton.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                ProductDetailsActivity::class.java
            )

            intent.putExtra("name", product.name)

            intent.putExtra("price", product.price)

            intent.putExtra("image", product.image)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}