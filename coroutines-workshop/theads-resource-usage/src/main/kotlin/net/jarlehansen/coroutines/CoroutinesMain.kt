package net.jarlehansen.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Push any key to start coroutines")
    readLine()

    println("Started")
    repeat((0..ThreadsMain.NUMBER_OF_THREADS).count()) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}