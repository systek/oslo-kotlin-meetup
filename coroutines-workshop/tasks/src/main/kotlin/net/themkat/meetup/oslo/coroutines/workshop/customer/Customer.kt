package net.themkat.meetup.oslo.coroutines.workshop.customer

// Customer entry in a shop. For now has an id, name and points.
// points is the store loyalty points the customer have in the shop (gotten based on number of items and item cost)
data class Customer(val id: Int, val name: String, val points: Int)