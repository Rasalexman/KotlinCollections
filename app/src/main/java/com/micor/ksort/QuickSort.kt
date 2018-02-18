package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 * Quicksort - эффективный алгоритм сортировки с использованием подхода divide и conquer. Quicksort сначала делит большой массив на два меньших подмассива: низкие элементы
 * и высокие элементы. Quicksort может затем рекурсивно сортировать подмассивы.
 */
class QuickSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        arrange(arr, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> arrange(arr: Array<T>, low: Int, high: Int) {
        if (high <= low) return
        val j = partition(arr, low, high)
        arrange(arr, low, j - 1)
        arrange(arr, j + 1, high)
    }

    private fun <T : Comparable<T>> partition(arr: Array<T>, low: Int, high: Int): Int {
        var i = low
        var j = high + 1
        val v = arr[low]
        while (true) {
            while (arr[++i] < v) {
                if (i == high) break
            }
            while (v < arr[--j]) {
                if (j == low) break
            }
            if (j <= i) break
            arr.exchange(j, i)
        }
        arr.exchange(j, low)
        return j
    }
}