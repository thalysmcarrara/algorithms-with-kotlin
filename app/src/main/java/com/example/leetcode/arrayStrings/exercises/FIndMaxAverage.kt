package com.example.leetcode.arrayStrings.exercises

val array = intArrayOf(0,4,0,3,2)

fun main() {
    println(findMaxAverage(array, 1))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var currSubArraySum = 0.0

    /* Como o tamanho da janela é fixa(k) devemos logo de cara calcular a média da primeira janela
    *  começando pelo indice 0 até k - 1
    * */
    for (index in 0 until k) {
        currSubArraySum += nums[index]
    }

    var ans = currSubArraySum / k


    /*  Após calcular a média da primeira janela fica simples calcular as outras apenas somando o
    *   valor de nums[index] menos a posição nums[index - k] a variável currSubArraySum.
    *
    *   Após calcular a média da janela atual devemos comparar a média da janela anterior com a
    *   atual e ficar a maior.
    */
    for (index in k until nums.size) {
        currSubArraySum += nums[index] - nums[index - k]
        val currAvg = currSubArraySum / k
        ans = if (ans > currAvg) ans else currAvg
    }
    return ans
}
