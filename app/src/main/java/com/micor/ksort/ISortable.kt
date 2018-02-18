package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 */
interface ISortable<T : Comparable<T>> {
    fun sort(arr:Array<T>)
}

inline fun <T> Array<T>.exchange(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}