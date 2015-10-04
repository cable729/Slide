package cable.slide.module.puzzle

interface Board<T : Tile<T>> {
    val size: Int
    fun getTileAt(row: Int, column: Int): T
    fun setTileAt(row: Int, column: Int, value: T)
}