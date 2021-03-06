package day01

import java.io.File

fun main() {

    val input = File("aoc2019/src/day01/input.txt").readLines()

    val answer = totalFuelNeeded(input.map(String::toInt))
    println(answer)
}

private fun totalFuelNeeded(masses: List<Int>) = masses.map(::fuelNeeded).sum()

private fun fuelNeeded(mass: Int): Int {

    val additionalFuelNeeded = mass / 3 - 2
    return if (additionalFuelNeeded <= 0) 0 else fuelNeeded(additionalFuelNeeded) + additionalFuelNeeded
}