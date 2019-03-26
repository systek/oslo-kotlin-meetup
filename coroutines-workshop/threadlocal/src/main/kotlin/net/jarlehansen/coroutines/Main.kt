package net.jarlehansen.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

fun matcherThreads() {
    val threadLocal = ThreadLocal<Int>()
    repeat(100) {
        thread(start = true) {
            threadLocal.set(it)
            Thread.sleep(Random.nextLong(100))
            val threadLocalValue = threadLocal.get()
            if (it == threadLocalValue) {
                println("matches")
            } else {
                println("does not match! $it - $threadLocalValue")
            }
        }
    }
}

fun matcherCoroutines() {
    val threadLocal = ThreadLocal<Int>()
    val dispatcher = newFixedThreadPoolContext(10, "coroutines-example")
    runBlocking {
        repeat(100) {
            threadLocal.set(it)
            launch(dispatcher) {
                delay(Random.nextLong(100))
                val threadLocalValue = threadLocal.get()
                if (it == threadLocalValue) {
                    println("matches")
                } else {
                    println("does not match! $it - $threadLocalValue")
                }
            }
        }
    }
}

fun main() {
    matcherThreads()
    matcherCoroutines()
}