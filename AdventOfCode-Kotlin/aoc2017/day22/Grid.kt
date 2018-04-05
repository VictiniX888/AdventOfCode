package day22

enum class State {
    CLEAN, WEAKENED, INFECTED, FLAGGED
}

enum class Direction {
    RIGHT, LEFT, UP, DOWN
}

class SquareGrid(init: List<State>, var size: Int) {

    data class Carrier(var posX: Int, var posY: Int, var direction: Direction = Direction.UP) {

        fun forward() {
            when (direction) {
                Direction.RIGHT -> posX++
                Direction.LEFT  -> posX--
                Direction.UP    -> posY--
                Direction.DOWN  -> posY++
            }
        }

        fun turn(dir: Direction) {
            direction = when (dir) {
                Direction.LEFT ->
                    when (direction) {
                        Direction.LEFT -> Direction.DOWN
                        Direction.RIGHT -> Direction.UP
                        Direction.UP -> Direction.LEFT
                        Direction.DOWN -> Direction.RIGHT
                    }
                Direction.RIGHT ->
                    when (direction) {
                        Direction.LEFT -> Direction.UP
                        Direction.RIGHT -> Direction.DOWN
                        Direction.UP -> Direction.RIGHT
                        Direction.DOWN -> Direction.LEFT
                    }
                Direction.DOWN ->
                        when (direction) {
                            Direction.LEFT -> Direction.RIGHT
                            Direction.RIGHT -> Direction.LEFT
                            Direction.UP -> Direction.DOWN
                            Direction.DOWN -> Direction.UP
                        }
                else -> direction
            }
        }
    }

    val grid = init.toMutableList()
    var infections = 0

    private val gridCentre = size / 2
    val carrier = Carrier(gridCentre, gridCentre)

    fun index(posX: Int, posY: Int)  = (posY * size) + posX

    fun enlarge() {

        repeat(size + 1) {
            grid.add(State.CLEAN)
        }
        for (i in size downTo 1) {
            repeat(2) { grid.add(i*size, State.CLEAN) }
        }
        repeat(size + 3) {
            grid.add(0, State.CLEAN)
        }

        carrier.posX++
        carrier.posY++
        size += 2
    }
}