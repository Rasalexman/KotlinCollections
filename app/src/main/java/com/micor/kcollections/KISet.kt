/*
 * Copyright (c) 2017 Alexander Minkin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.micor.kcollections

/**
 * ImmutableSet
 */
class KISet<T: Comparable<T>>(values: Array<T>): Set<T> {
    private val arr: Array<T> = values.sortedArray()
    private val bs = KBinarySearch<T>() // TODO: remove

    override val size: Int
        get() = arr.size

    override fun contains(element: T): Boolean  = bs.perform(arr, element) != -1
    override fun containsAll(elements: Collection<T>): Boolean = elements.all { contains(it) }
    override fun isEmpty(): Boolean  = size == 0
    override fun iterator(): Iterator<T>  = arr.iterator()
}

