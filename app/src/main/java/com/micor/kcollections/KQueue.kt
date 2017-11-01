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

import java.util.*

class KQueue<T> : Collection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size: Int = 0
        private set

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    fun add(item: T) {
        val new = Node(item)
        val tail = this.tail
        if (tail == null) {
            head = new
            this.tail = new
        } else {
            tail.next = new
            this.tail = new
        }
        size++
    }

    fun peek(): T {
        if (isEmpty()) throw NoSuchElementException()
        return head!!.value
    }

    fun poll(): T {
        if (isEmpty()) throw NoSuchElementException()
        val old = head!!
        head = old.next
        return old.value
    }

    override fun isEmpty(): Boolean = size == 0
    override fun contains(element: T): Boolean = this.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = elements.any { contains(it) }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var node = head
            override fun hasNext(): Boolean = node != null
            override fun next(): T {
                if (!hasNext()) throw NoSuchElementException()
                val current = node!!
                node = current.next
                return current.value
            }
        }
    }
}