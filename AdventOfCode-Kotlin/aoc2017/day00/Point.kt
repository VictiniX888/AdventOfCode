package day00

enum class Direction {
    RIGHT, LEFT, UP, DOWN
}

data class Point(var x: Int, var y: Int) {

    fun move(direction: Direction) {
        when (direction) {
            Direction.RIGHT -> x++
            Direction.LEFT  -> x--
            Direction.UP    -> y++
            Direction.DOWN  -> y--
        }
    }
}