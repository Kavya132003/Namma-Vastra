package com.example.namma_vastra

data class Order(

    var orderId: String = "",

    var userId: String = "",

    var customerName: String = "",

    var address: String = "",

    var phone: String = "",

    var products: String = "",

    var totalPrice: String = "",

    var status: String = "PLACED",

    var timestamp: Long = System.currentTimeMillis()
)