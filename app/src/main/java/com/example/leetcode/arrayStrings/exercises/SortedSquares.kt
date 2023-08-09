package com.example.leetcode.arrayStrings.exercises

val intArray = intArrayOf(-7,-3,2,3,11)

fun main() {
    sortedSquares(intArray)
    intArray.forEach {
        print("$it, ")
    }
}

fun sortedSquares(nums: IntArray): IntArray {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        nums[left] = nums[left] * nums[left]
        if (left != right) {
            nums[right] = nums[right] * nums[right]
        }
        left++
        right--
    }

    nums.sort()

    return nums
}