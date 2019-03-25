package net.themkat.meetup.oslo.coroutines.workshop.pi

import kotlin.math.pow

fun wallisPi(accuracy: Int): Double {
    return 2.0 * (1..accuracy).map {
        val n = it.toFloat()
        val twoTimesN = 2.0 * n
        val dividend = twoTimesN.pow(2)
        val divisor = (twoTimesN - 1.0) * (twoTimesN + 1.0)

        dividend / divisor
    }.reduce { acc, curr ->
        acc * curr
    }
}