package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 * Сортировка вставки повторяется, потребляя один входной элемент при каждом повторении и увеличивая отсортированный выходной список.
 * Каждая итерация - это удаление одного элемента из входных данных, нахождение местоположения, которое оно занимает в
 * отсортированном списке, и вставка его там. Он повторяется до тех пор, пока не останется никаких элементов ввода.
 */
class InsertionSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        for (i in 1 until arr.size) {
            (i downTo 1)
                    .takeWhile { arr[it - 1] >= arr[it] }
                    .forEach { arr.exchange(it, it - 1) }
        }
    }
}