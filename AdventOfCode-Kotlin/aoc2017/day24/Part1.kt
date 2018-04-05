package day24

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day24/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getStrongest(build(Bridge(listOf(Component(0, 0))), parseInput(input)))
        println(output)
    }
}

private fun getStrongest(bridges: List<Bridge>): Int = bridges.map { it.strength }.max() ?: -1

private fun build(bridge: Bridge, components: List<Component>): List<Bridge> {

    val newComponents = components.toList()

    val connectable = components.filter { it.canConnect(bridge.endPort) }

    return if (connectable.isNotEmpty()) {
        connectable
                .map { if (it.port2 == bridge.endPort) it.flip() else it }
                .flatMap { build(bridge.addComponent(it), if (newComponents.contains(it)) newComponents - it else newComponents - it.flip()) }
    }
    else {
        listOf(bridge)
    }
}

private fun parseInput(input: List<String>): List<Component> {

    return input.map { it ->
        val (a, b) = it.split("/").map { i -> i.toInt() }
        Component(a, b)
    }
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}