package net.jarlehansen.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Push any key to start coroutines")
    readLine()

    println("Started")
    repeat(ThreadsMain.NUMBER_OF_THREADS) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}
