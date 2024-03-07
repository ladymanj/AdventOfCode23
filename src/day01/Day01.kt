package day01

import println
import readInput

const val inputFile = "day01/Day01"
const val testInputPart1File = "day01/Day01_part1_test"
const val testInputPart2File = "day01/Day01_part2_test"

val wordNumbers = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun main() {
    fun part1(input: List<String>): Int {
        val intList = mutableListOf<Int>()
        for (inputLine in input) {
            var firstDigitChar = '0'
            var lastDigitChar = '0'
            for (char in inputLine) {
                if (char.isDigit()) {
                    firstDigitChar = char
                    break
                }
            }
            for (char in inputLine.reversed()) {
                if (char.isDigit()) {
                    lastDigitChar = char
                    break
                }
            }
            val fullNumberString: String = "" + firstDigitChar + lastDigitChar
            intList.add(fullNumberString.toInt())
        }
        return intList.sum()
    }

    fun part2(input: List<String>): Int {
        val intList = mutableListOf<Int>()
        for (inputLine in input) {
            val firstDigit: Char = checkForLettersForward(inputLine)
            val lastDigit: Char = checkForLettersBackward(inputLine)
            val fullNumberString: String = "" + firstDigit + lastDigit
            intList.add(fullNumberString.toInt())
        }
        return intList.sum()
    }

    val testInputPart1 = readInput(testInputPart1File)
    check(part1(testInputPart1) == 142)

    val testInputPart2 = readInput(testInputPart2File)
    check(part2(testInputPart2) == 281)

    val input = readInput(inputFile)
    part1(input).println()
    part2(input).println()
}

fun checkForLettersForward(inputString: String): Char {
    for (i in inputString.indices) {
        val charFromString: Char = searchForNumbersForward(i, inputString)
        if (charFromString != '0') {
            return charFromString
        }
    }
    return '0'
}

fun checkForLettersBackward(inputString: String): Char {
    for (i in inputString.length - 1 downTo 0) {
        val charFromString: Char = searchForNumbersBackward(i, inputString)
        if (charFromString != '0') {
            return charFromString
        }
    }
    return '0'
}

fun searchForNumbersForward(index: Int, input: String): Char {
    if (input[index].isDigit()) {
        return input[index]
    } else {
        for (word in wordNumbers) {
            if (input.indexOf(word) == index) {
                return getCharNumFromWord(word)
            }
        }
    }
    return '0'
}

fun searchForNumbersBackward(index: Int, input: String): Char {
    if (input[index].isDigit()) {
        return input[index]
    } else {
        for (word in wordNumbers) {
            if (input.lastIndexOf(word) == index) {
                return getCharNumFromWord(word)
            }
        }
    }
    return '0'
}

fun getCharNumFromWord(word: String): Char {
    return when (word) {
        "one" -> '1'
        "two" -> '2'
        "three" -> '3'
        "four" -> '4'
        "five" -> '5'
        "six" -> '6'
        "seven" -> '7'
        "eight" -> '8'
        "nine" -> '9'
        else -> {
            '0'
        }
    }
}
