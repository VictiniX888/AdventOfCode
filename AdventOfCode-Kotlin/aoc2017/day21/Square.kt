package day21

data class Square(val square: List<List<Boolean>>) {

    val size = square.size

    fun flipHorizontal(): Square {

        return Square(square.map { it.reversed() })
    }

    fun flipVertical(): Square {

        return Square(square.reversed())
    }

    fun rotate(degree: Int): Square {

        val list = MutableList(size) {
            MutableList(size) {
                false
            }
        }

        for (c in size-1 downTo 0) {
            for (r in 0 until size) {
                list[r][c] = square[size-1-c][r]
            }
        }

        return when(degree) {
            90   -> Square(list)
            180  -> Square(list).rotate(90)
            270  -> Square(list).rotate(180)
            else -> Square(list)
        }
    }

    fun variants(): Set<Square> {

        return setOf(this, this.flipHorizontal(), this.flipVertical(), rotate(90), rotate(90).flipHorizontal(), rotate(90).flipVertical(), rotate(180), rotate(270))
    }

    fun enhance(rules: Map<Square, Square>): Square {

        return rules.getOrDefault(this, this)
    }

    fun chunk(size: Int): List<Square> {

        val list = mutableListOf<Square>()

        for (r in 0 until this.size step size) {
            for (c in 0 until this.size step size) {
                val tempSquare = mutableListOf<List<Boolean>>()
                for (row in 0 until size) {
                    val tempRow = mutableListOf<Boolean>()
                    for (column in 0 until size) {
                        tempRow.add(square[r+row][c+column])
                    }
                    tempSquare.add(tempRow)
                }
                list.add(Square(tempSquare))
            }
        }

        return list
    }

    fun getOn(): Int {

        return square.flatMap { it.filter { light -> light } }.count()
    }

    fun get(row: Int, column: Int): Boolean {

        return square[row][column]
    }
}