package com.micor.kcollections

/**
 * Created by a.minkin on 01.11.2017.
 */
fun <T> Array<T>.exch(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun <T: Comparable<T>> immutableSetOf(vararg elements: T): KISet<out T> {
    return KISet(elements.copyOf())
}

class KBinarySearch<T: Comparable<T>> {
    fun perform(arr: Array<T>, element: T): Int {
        var lo = 0
        var hi = arr.size - 1
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            when {
                element < arr[mid] -> hi = mid - 1
                element > arr[mid] -> lo = mid + 1
                else -> return mid
            }
        }
        return -1
    }
}