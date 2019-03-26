package net.themkat.meetup.oslo.coroutines.workshop.customer

import org.apache.commons.lang3.RandomStringUtils

fun fetchCustomer(id: Int): Customer {
    Thread.sleep(1000)
    println("Fetching customer: $id")
    return Customer(id, RandomStringUtils.randomAlphabetic(15), (0..10000).random())
}