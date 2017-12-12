package day11

enum class Direction {
    NORTH, NORTHEAST, SOUTHEAST, SOUTH, SOUTHWEST, NORTHWEST
}

data class Point(var x: Int, var y: Int) {

    fun move(direction: Direction) {
        when (direction) {
            Direction.NORTH -> y += 2
            Direction.NORTHEAST -> {x++; y++}
            Direction.SOUTHEAST -> {x++; y--}
            Direction.SOUTH -> y -= 2
            Direction.SOUTHWEST -> {x--; y--}
            Direction.NORTHWEST -> {x--; y++}
        }
    }
}