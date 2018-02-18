package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 *
 * Shellsort, также известный как Shell-сортировка или метод Shell, представляет собой сортировку на месте. Это можно рассматривать как либо обобщение
 * сортировки путем обмена (BubbleSort), либо сортировка путем вставки (InsertionSort). Метод начинается с
 * сортировки пар элементов, находящихся далеко друг от друга, а затем постепенного уменьшения разрыва между элементами, которые будут сравниваться.
 */
class ShellSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        var h = 1
        while (h < arr.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            for (i in h until arr.size) {
                (i downTo h step h)
                        .takeWhile { arr[it - h] >= arr[it] }
                        .forEach { arr.exchange(it, it - h) }
            }
            h /= 3
        }
    }
}