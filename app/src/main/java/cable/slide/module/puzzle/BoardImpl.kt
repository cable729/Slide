package cable.slide.module.puzzle

import java.util.*

class BoardImpl<T : Tile<T>> private constructor(override val size: Int) : Board<T> {

    private val list: ArrayList<T> = ArrayList(totalTiles())
    private val widthAndHeightBounds = 0..size - 1

    constructor(size: Int, init: (row: Int, column: Int) -> T) : this(size) {
        for (index in 0..totalTiles() - 1) {
            list.add(init(rowOfIndex(index), columnOfIndex(index)))
        }
    }

    private fun totalTiles() = size * size
    private fun rowOfIndex(index: Int) = index / size
    private fun columnOfIndex(index: Int) = index % size
    private fun indexOf(row: Int, column: Int) = size * row + column

    override fun getTileAt(row: Int, column: Int): T {
        checkBounds(row, column)
        return list[indexOf(row, column)]
    }

    override fun setTileAt(row: Int, column: Int, value: T) {
        checkBounds(row, column)
        list[indexOf(row, column)] = value
    }

    private fun checkBounds(row: Int, column: Int) {
        if (row !in widthAndHeightBounds) {
            throw IndexOutOfBoundsException("row out of bounds: $widthAndHeightBounds")
        }
        if (column !in widthAndHeightBounds) {
            throw IndexOutOfBoundsException("column out of bounds: $widthAndHeightBounds")
        }
    }
}