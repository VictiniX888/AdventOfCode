package day20

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day20/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = moveParticles(parseParticles(input)).size
        println(output)
    }
}

private fun moveParticles(particles: List<Particle>): List<Particle> {

    val newParticles = particles.toMutableList()

    repeat (5000) {

        newParticles.forEach { it.move() }
        newParticles.eliminateCollisions()
    }

    return newParticles
}

private fun MutableList<Particle>.eliminateCollisions() {

    val positions = mutableSetOf<Triple<Int, Int, Int>>()
    val collided = mutableSetOf<Triple<Int, Int, Int>>()

    this.forEach { if (positions.contains(Triple(it.posX, it.posY, it.posZ))) { collided.add(Triple(it.posX, it.posY, it.posZ))} else positions.add(Triple(it.posX, it.posY, it.posZ)) }
    if (collided.size > 0) {
        this.removeAll { collided.contains(Triple(it.posX, it.posY, it.posZ)) }
    }
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