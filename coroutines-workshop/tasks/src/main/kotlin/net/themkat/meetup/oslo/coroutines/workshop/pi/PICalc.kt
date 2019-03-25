package net.themkat.meetup.oslo.coroutines.workshop.pi

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    val startAcc = 10_000_000

    // naive sequential way
    val seqTime = measureTimeMillis {
        (startAcc..startAcc + 25).forEach {
            val formattedPi = "%.25f".format(wallisPi(it))
            println("Accuracy: $it, PI value:  $formattedPi")
        }
    }
    println("Sequential time taken: $seqTime ms\n\n")


    // coroutines version
    val asyncTime = measureTimeMillis {
        (startAcc..startAcc + 25).map {
            launch {
                val formattedPi = "%.25f".format(wallisPi(it))
                println("Accuracy: $it, PI value:  $formattedPi")
            }
        }.map {
            it.join()
        }
    }
    println("Coroutine ascyn time taken: $asyncTime ms\n\n")
}