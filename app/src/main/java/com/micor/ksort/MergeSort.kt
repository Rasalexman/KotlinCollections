package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 * merge sort - эффективный алгоритм с использованием подхода divide и conquer
 *, который заключается в том, чтобы разделить большую проблему на более мелкие задачи и решить их. По идее, сортировка слияния работает следующим образом:
 * 1) Разделите несортированный список на n подсписков, каждый из которых содержит 1 элемент (список из 1 элемента считается отсортированным).
 * 2) Неоднократно объединять подсписки для создания новых отсортированных подсписок до тех пор, пока не останется только 1 подсписок.
 */
class MergeSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        val aux = arr.clone()
        arrange(arr, aux, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> arrange(arr: Array<T>, aux: Array<T>, low: Int, high: Int) {
        if (high <= low) return
        val mid = (low + high) / 2
        arrange(arr, aux, low, mid)
        arrange(arr, aux, mid + 1, high)
        merge(arr, aux, low, mid, high)
    }

    private fun <T : Comparable<T>> merge(arr: Array<T>, aux: Array<T>, low: Int, middle: Int, high: Int) {
        System.arraycopy(arr, low, aux, low, high - low + 1)

        var i = low
        var j = middle + 1
        for (k in low..high) {
            when {
                i > middle -> arr[k] = aux[j++]
                j > high -> arr[k] = aux[i++]
                aux[j] < aux[i] -> arr[k] = aux[j++]
                else -> arr[k] = aux[i++]
            }
        }
    }

}