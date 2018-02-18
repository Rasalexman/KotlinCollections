package com.micor.ksort

/**
 * Created by alexander on 18.02.2018.
 * Bubble sort - это простой алгоритм сортировки, который многократно выполняет сортировку списка, сравнивает
 * каждую пару соседних элементов и свопирует(меняет местами) их, если они находятся в неправильном порядке. Проход по списку повторяется
 * до тех пор, пока не потребуются свопы, что указывает на то, что список отсортирован.
 */
class BubbleSort<T : Comparable<T>> : ISortable<T> {
    override fun sort(arr: Array<T>) {
        var exchanged: Boolean
        do {
            exchanged = false
            for (i in 1 until arr.size) {
                if (arr[i] < arr[i - 1]) {
                    arr.exchange(i, i - 1)
                    exchanged = true
                }
            }
        } while (exchanged)
    }
}