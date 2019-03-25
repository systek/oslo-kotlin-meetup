package net.themkat.meetup.oslo.coroutines.workshop.customer

import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) = runBlocking {

    // Sequential solution
    val seqTime = measureTimeMillis {
        (0..25).map(::fetchCustomer).sortedByDescending {
            it.points
        }.forEach {
            println(it)
        }
    }
    println("Sequential time in milliseconds: $seqTime ms\n\n")

}
