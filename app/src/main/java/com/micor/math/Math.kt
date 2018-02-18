package com.micor.math

/**
 * Created by alexander on 18.02.2018.
 */

/**
 * Greatest common divisor - наибольший общий делитель (gcd) двух или более целых чисел,
 * которые не все равны нулю, является наибольшим положительным целым числом, которое делит каждый из целых чисел
 */
fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

/**
 * Least common multiple - наименьшее общее кратное, минимальное общее кратное или наименьшее общее кратное из двух целых чисел a и b,
 * обычно обозначаемое LCM (a, b), является наименьшим положительным целым числом, которое делится на a и b
 */
fun lcm(a: Int, b: Int): Int {
    return a / gcd(a, b) * b
}

/**
 * Сколько способов можно выбрать k из n?
 */
fun binomial(n: Int, k: Int): Long {
    var j = n - k + 1
    var binomial = 1L
    for (i in 1 until k + 1) {
        binomial = binomial * j / i
        j++
    }
    return binomial
}

/**
 * Метод Ньютона,
 * алгоритм Ньютона (также известный как метод касательных) — это итерационный численный метод нахождения корня (нуля) заданной функции.
 */
fun sqrt(c: Int, e: Double = 1e-15): Double {
    return sqrtComp(c.toDouble(), e)
}

fun sqrtComp(c: Double, e: Double = 1e-15): Double {
    if (c < 0) return Double.NaN
    var t = c
    while (Math.abs(t - c / t) > e * t)
        t = (c / t + t) * 0.5
    return t
}