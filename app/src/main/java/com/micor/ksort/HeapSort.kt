package com.micor.ksort

import com.micor.kcollections.KPQueue

/**
 * Created by alexander on 18.02.2018.
 * Heap sort - метод сортировки, где мы сначала находим максимальный элемент и помещаем максимальный элемент в конец.
 * Мы повторяем тот же процесс для оставшегося элемента.
 */
class HeapSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        for (k in arr.size / 2 downTo 1) {
            KPQueue.sink(arr as Array<T?>, k - 1, arr.size - 1, reverseOrder<T>())
        }
        for (k in arr.size downTo 1) {
            arr.exchange(0, k - 1)
            KPQueue.sink(arr as Array<T?>, 0, k - 2, reverseOrder<T>())
        }
    }
}