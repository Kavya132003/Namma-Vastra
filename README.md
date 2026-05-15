# Namma-Vastra 👗

### AI-Powered Sustainable Saree Marketplace & Ecommerce Platform

Namma-Vastra is a modern Android ecommerce application designed to support sustainable fashion and self-employment through a digital saree marketplace ecosystem. The platform enables users to browse, search, wishlist, purchase, and track sarees while providing sellers with complete order lifecycle management.

Built using Kotlin, Firebase, and Firestore, the project combines elegant UI design with scalable cloud-backed architecture inspired by real-world ecommerce systems.

---

# 🌟 Features

## 👤 User Authentication

* Firebase Authentication
* Secure Login & Registration
* Persistent User Sessions

---

# 🛍️ Product Management

* Dynamic Product Listing
* Product Detail Screen
* Beautiful Product Cards
* Firestore-based Product Storage
* Search Functionality

---

# ❤️ Wishlist System

* Add products to wishlist
* Remove products from wishlist
* Persistent wishlist storage

---

# 🛒 Cart System

* Add to cart
* Quantity management
* Total price calculation
* Real-time cart updates

---

# 📦 Order Management System

Users can:

* Place orders
* Store orders permanently in Firestore
* View order history
* Access detailed order information

---

# 🚚 Order Lifecycle Tracking

Complete ecommerce logistics workflow:

```text
PLACED
   ↓
CONFIRMED
   ↓
SHIPPED
   ↓
DELIVERED
```

Includes:

* Timeline UI
* Status badges
* Live order progression

---

# 🧑‍💼 Seller Dashboard

Sellers can:

* View all customer orders
* Manage order lifecycle
* Confirm orders
* Mark orders as shipped
* Mark orders as delivered

---

# 🔔 Push Notification System (FCM)

Integrated Firebase Cloud Messaging:

* Order update notifications
* Seller-to-buyer communication
* Real-time status alerts

---

# 🎨 Premium UI System

* Elegant ecommerce layouts
* Luxury saree-inspired theme
* Modern card-based design
* Soft color palettes
* Responsive RecyclerViews
* Bottom Navigation System

---

# ☁️ Firebase Architecture

## Firestore Collections

```text
products
orders
users
wishlist
```

---

# 🏗️ Tech Stack

## Frontend

* Kotlin
* XML Layouts
* RecyclerView
* Material Design Components

## Backend

* Firebase Firestore
* Firebase Authentication
* Firebase Cloud Messaging (FCM)

## Architecture

* Cloud-based realtime database
* Scalable ecommerce workflow
* Modular Android architecture

---

# 📱 Application Modules

## Customer Side

* Authentication
* Product browsing
* Cart management
* Wishlist
* Checkout
* Order tracking

## Seller Side

* Seller dashboard
* Order management
* Lifecycle control
* Status updates

---

# 🧠 Smart Features

* Dynamic search filtering
* Real-time Firestore updates
* Timeline-based order tracking
* Intelligent status UI
* Notification-driven updates

---

# 🚀 Future Enhancements

* AI Recommendation Engine
* Live Delivery Tracking using Google Maps
* Analytics Dashboard
* Voice-Based Shopping Assistant
* AI Saree Styling Suggestions
* Payment Gateway Integration
* AR Saree Preview System

---

# 📂 Project Structure

```text
com.example.namma_vastra
│
├── adapters
│   ├── ProductAdapter
│   ├── CartAdapter
│   ├── OrderAdapter
│   └── SellerOrderAdapter
│
├── models
│   ├── Product
│   └── Order
│
├── activities
│   ├── LoginActivity
│   ├── RegisterActivity
│   ├── HomeActivity
│   ├── CartActivity
│   ├── WishlistActivity
│   ├── CheckoutActivity
│   ├── OrderHistoryActivity
│   ├── OrderDetailActivity
│   ├── SellerDashboardActivity
│   └── SellerOrderManagementActivity
```

---

# ⚙️ Installation

## 1️⃣ Clone Repository

```bash
git clone https://github.com/Kavya132003/Namma-Vastr
```

---

## 2️⃣ Open in Android Studio

* Open Android Studio
* Select:

  ```text
  Open Existing Project
  ```

---

## 3️⃣ Connect Firebase

* Add `google-services.json`
* Enable:

  * Firestore Database
  * Authentication
  * Cloud Messaging

---

## 4️⃣ Sync Gradle

```bash
Sync Project with Gradle Files
```

---

## 5️⃣ Run Application

Connect emulator/device and run:

```bash
Shift + F10
```

---

# 📸 Screens Included

* Splash Screen
* Login & Registration
* Product Listing
* Product Details
* Cart Screen
* Wishlist Screen
* Checkout Screen
* Order Timeline
* Seller Dashboard
* Order Management

---

# 🎯 Project Vision

Namma-Vastra aims to digitally empower traditional textile and saree businesses by providing a scalable AI-powered ecommerce ecosystem that supports sustainable fashion, self-employment, and intelligent commerce experiences.

---

# 👩‍💻 Developed By

Kavya
Bachelor of Engineering in Artificial Intelligence & Machine Learning

---

# 📜 License

This project is developed for educational, innovation, and portfolio purposes.
