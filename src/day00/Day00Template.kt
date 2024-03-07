package day00

import println
import readInput

const val inputFile = "day00/Day00"
const val testInputPart1File = "day00/Day00_part1_test"
const val testInputPart2File = "day00/Day00_part2_test"

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputPart1 = readInput(testInputPart1File)
    check(part1(testInputPart1) == 123)

    val testInputPart2 = readInput(testInputPart2File)
    check(part2(testInputPart2) == 321)

    val input = readInput(inputFile)
    part1(input).println()
    part2(input).println()
}