package day20

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day20/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = findClosest(parseParticles(input))
        println(output)
    }
}

private fun findClosest(particles: List<Particle>): Int {

    return particles.minBy { it.accX.absoluteValue + it.accY.absoluteValue + it.accZ.absoluteValue }?.id ?: -1
}

private fun parseParticles(list: List<String>): List<Particle> {

    return list
            .map { it.drop(3).dropLast(1).split(">, v=<", ">, a=<", ",").map { i -> i.toInt() } }
            .mapIndexed { i, it -> Particle(i, it[0], it[1], it[2], it[3], it[4], it[5], it[6], it[7], it[8]) }
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}