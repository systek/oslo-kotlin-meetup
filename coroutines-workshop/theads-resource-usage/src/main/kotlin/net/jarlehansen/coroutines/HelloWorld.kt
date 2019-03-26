package net.jarlehansen.coroutines

import kotlin.system.measureTimeMillis


fun main() {
    val timeUsed = measureTimeMillis {
        val text = "hello world"
        var mutableText = text

        println(text)
    }
}