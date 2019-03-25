package net.themkat.meetup.oslo.coroutines.workshop.customer

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
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


    // simple coroutine solution using async
    val asyncTime = measureTimeMillis {
        (0..25).map {
            async(Dispatchers.Default, CoroutineStart.ATOMIC) {
                fetchCustomer(it)
            }
        }.map {
            it.await()
        }.sortedByDescending {
            it.points
        }.forEach {
            println(it)
        }
    }
    println("Coroutine async time: $asyncTime ms\n\n")


    // channels based solution
    val channelsTime = measureTimeMillis {
        val customerChannel = Channel<Customer>()

        // producer
        (0..25).forEach {
            launch(Dispatchers.Default) {
                customerChannel.send(fetchCustomer(it))
            }
        }

        // consumer
        (0..25).map {
            customerChannel.receive()
        }.sortedByDescending {
            it.points
        }.forEach {
            println(it)
        }

    }
    println("Coroutine channels time: $channelsTime ms\n\n")

}
