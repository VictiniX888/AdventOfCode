package day02

import intcode.Intcode
import java.io.File

fun main() {

    val input = File("aoc2019/src/day02/input.txt")
            .readText()
            .split(",")
            .map(String::toInt)
            .toMutableList()

    input[1] = 12
    input[2] = 2

    val completedProgram = runIntcodeComputer(input)
    val answer = completedProgram[0]
    println(answer)
}

private fun runIntcodeComputer(input: List<Int>): List<Int> = Intcode(input).run()