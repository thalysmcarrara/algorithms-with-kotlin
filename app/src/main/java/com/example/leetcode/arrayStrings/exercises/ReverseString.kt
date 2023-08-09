package com.example.leetcode.arrayStrings.exercises

val charArray = charArrayOf('a', 'n', 'o')

fun main() {
    reverseString(charArray)
    println(charArray)
}

fun reverseString(charArray: CharArray) {
    var left = 0
    var right = charArray.lastIndex

    while (left < right) {
        var aux = charArray[right]
        charArray[right] = charArray[left]
        charArray[left] = aux
        left++
        right--
    }
}