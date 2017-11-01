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
 * BinaryTree
 */
class KBTree(var value: Int, var left: KBTree?, var right: KBTree?) {
    constructor(value: Int) : this(value, null, null)

    fun size(): Int {
        var size = 1
        left?.let {
            size += it.size()
        }
        right?.let {
            size += it!!.size()
        }
        return size
    }

    fun height(): Int {
        val left = if (left == null) 0 else left!!.height()
        val right = if (right == null) 0 else right!!.height()
        return maxOf(left, right) + 1
    }

    fun add(value: Int) {
        // adds the on the first empty level
        val queue = KQueue<KBTree>()
        queue.add(this)
        while (!queue.isEmpty()) {
            val x = queue.poll()
            if (x.left == null) {
                x.left = KBTree(value)
                return
            } else if (x.right == null) {
                x.right = KBTree(value)
                return
            } else {
                queue.add(x.left!!)
                queue.add(x.right!!)
            }
        }
    }
}