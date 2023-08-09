package com.example.leetcode.arrayStrings

val stringTest = "racecar"
val sortIntArray: IntArray = intArrayOf(1, 2, 4, 6, 8, 9, 14, 15)
val list1 = listOf(1, 4, 7, 20)
val list2 = listOf(3, 5, 6)

fun main() {
    println(combineArrays(list1, list2))
}

fun checkIfPalindrome(string: String) : Boolean {
    var right = 0
    var left = string.lastIndex

    while (left > right) {
        if (string[left] != string[right]) return false
        right++
        left--
    }

    return true
}


// the array need to be sorted
fun checkForTarget(nums: IntArray, target: Int): Boolean {
    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val currentSum = nums[left] + nums[right]
        if (currentSum == target) {
            println("${nums[left]} / ${nums[right]}")
            return true
        }

        if (currentSum > target) {
            right--
        } else {
            left ++
        }
    }

    return false
}

fun combineArrays(arr1: List<Int>, arr2: List<Int>): List<Int> {
    var i = 0
    var j = 0
    val ans: MutableList<Int> = mutableListOf()


    while (i < arr1.size && j < arr2.size) {
        if (arr1[i] < arr2[j]) {
            ans.add(arr1[i])
            i++
        } else {
            ans.add(arr2[j])
            j++
        }
    }

    while (i < arr1.size) {
        ans.add(arr1[i])
        i++
    }

    while (j < arr2.size) {
        ans.add(arr2[j])
        j++
    }

    return ans.toList()
 }
