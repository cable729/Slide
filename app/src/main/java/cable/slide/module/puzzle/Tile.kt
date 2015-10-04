package cable.slide.module.puzzle

interface Tile<T : Tile<T>> : Comparable<T> {
    fun isEmpty(): Boolean
}