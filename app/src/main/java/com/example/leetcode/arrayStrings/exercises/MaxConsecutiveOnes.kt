package com.example.leetcode.arrayStrings.exercises

private val binaryArray = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)

fun main() {
    println(findMaxConsecutiveOnes(binaryArray, 2))
}

fun findMaxConsecutiveOnes(nums: IntArray, k: Int): Int {
    var left = 0
    var curr = 0
    var ans = 0
    for (right in nums.indices) {
        if (nums[right] == 0) {
            curr += 1
        }

        while (curr > k) {
            if(nums[left] == 0) {
                curr -= 1
            }
            left++
        }
        val validWindowSize = right - left + 1
        ans = if (ans > validWindowSize) ans else validWindowSize
    }

    return ans
}