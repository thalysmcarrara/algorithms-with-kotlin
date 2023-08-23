package com.example.leetcode.arrayStrings

import kotlin.math.max

val intArray = intArrayOf(3, -1, 4, 12, -8, 5, 6)
val s = "1101100111"

fun main() {
    println(findBestSubArray(intArray, 4))
}

fun findLength(nums: IntArray, k: Int): Int {
    var ans = 0
    var curr = 0
    var left = 0

    for (right in 0..nums.lastIndex) {
        curr += nums[right]
        while (curr > k) {
            curr -= nums[left]
            left++
        }
        ans = max(ans, right - left + 1)
    }

    return ans
}


fun findLength(s: String): Int {
    var ans = 0
    var left = 0
    var curr = 0

    for (right in s.indices) {
        if (s[right] == '0') {
            curr += 1
        }

        while (curr > 1) {
            if (s[left] == '0') {
                curr--
            }
            left++
        }

        ans = max(ans, right - left + 1)
    }

    return ans
}


fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    if (k <= 1) {
        return 0
    }
    var ans = 0
    var left = 0
    var curr = 1
    for (right in nums.indices) {
        curr *= nums[right]
        while (curr >= k) {
            curr /= nums[left]
            left++
        }
        ans += right - left + 1
    }
    return ans
}

fun subarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var left = 0
    var currProduct = 1
    var ans = 0

    for (right in nums.indices) {
        currProduct *= nums[right]

        while (currProduct >= k) {
            currProduct /= nums[left]
            left += 1
        }
        ans += right - left  + 1
    }

    return ans
}

// [3, -1, 4, 12, -8, 5, 6]

fun findBestSubArray(nums: IntArray, k: Int): Int {
    var currSum = 0
    for (index in 0 until k) {
        currSum += nums[index]
    }
    var ans = currSum
    for (index in k until  nums.size) {
        currSum += nums[index] - nums[index - k]
        ans = max(ans, currSum)
    }

    return ans
}