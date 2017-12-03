package day03

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.*

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day03/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val inputInt = input.toInt()
        val output = getSpiralDistance(inputInt)
        println(output)
    }
}

private fun getSpiralDistance(n: Int): Int {   // solvable by hand, algorithm based on hand-solving method

    val distanceX = ceil(sqrt(n.toDouble())).toInt()  //these don't really represent the distance from 1
    val distanceY = distanceX*distanceX - n

    return if (distanceX % 2 == 1 && distanceY < distanceX) {
        ((distanceX - 1) / 2) + abs(((distanceX - 1) / 2) - distanceY)
    } else if (distanceX % 2 == 1) {
        getSpiralDistance(n + (distanceX-1)*(distanceX-1)/4)
    }
    else {
        getSpiralDistance(n + distanceX*distanceX/4)
    }
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}