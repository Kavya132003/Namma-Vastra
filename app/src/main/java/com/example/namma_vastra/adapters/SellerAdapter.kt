package com.example.namma_vastra.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namma_vastra.Product
import com.example.namma_vastra.R
import com.google.firebase.firestore.FirebaseFirestore

class SellerAdapter(
    private val productList: ArrayList<Product>,
    private val documentIds: ArrayList<String>
) : RecyclerView.Adapter<SellerAdapter.SellerViewHolder>() {

    class SellerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val image: ImageView =
            itemView.findViewById(R.id.sellerProductImage)

        val name: TextView =
            itemView.findViewById(R.id.sellerProductName)

        val price: TextView =
            itemView.findViewById(R.id.sellerProductPrice)

        val deleteButton: Button =
            itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SellerViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_seller_product,
                parent,
                false
            )

        return SellerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SellerViewHolder,
        position: Int
    ) {

        val product = productList[position]

        holder.name.text = product.name

        holder.price.text = product.price

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.image)

        holder.deleteButton.setOnClickListener {

            FirebaseFirestore.getInstance()
                .collection("products")
                .document(documentIds[position])
                .delete()

            productList.removeAt(position)

            documentIds.removeAt(position)

            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}