package cable.slide.module.puzzle

import junit.framework.TestCase
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BoardImplTest : TestCase() {

    private class MockStringTile(val message: String) : Tile<MockStringTile> {
        override fun isEmpty(): Boolean = message.isEmpty()
        override fun compareTo(other: MockStringTile): Int = message.compareTo(other.message)
    }

    fun boardOfStringCoordinates(width: Int) = BoardImpl(width) {
        row, column ->
        MockStringTile("$row,$column")
    }

    fun testGetTileAtAfterSettingWithInitFunction() {
        val testBoard = boardOfStringCoordinates(5)

        assertEquals(testBoard.getTileAt(0, 0).message, "0,0")
        assertEquals(testBoard.getTileAt(1, 0).message, "1,0")
        assertEquals(testBoard.getTileAt(4, 4).message, "4,4")
    }

    fun testGetTileAtAfterSettingWithSetTileAt() {
        val testBoard = boardOfStringCoordinates(5)
        val testStringTile = MockStringTile("test")
        testBoard.setTileAt(1, 1, testStringTile)
        assertEquals(testBoard.getTileAt(1, 1), testStringTile)
    }

    fun testGetTileAtThrowsExceptionForOutOfBoundsParameter() {
        val testBoard = boardOfStringCoordinates(2)
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.getTileAt(-1, 0) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.getTileAt(0, -1) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.getTileAt(2, 0) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.getTileAt(0, 2) }
    }

    fun testSetTileAtThrowsExceptionForOutOfBoundsParameter() {
        val testBoard = boardOfStringCoordinates(2)
        val testStringTile = MockStringTile("test")
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.setTileAt(-1, 0, testStringTile) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.setTileAt(0, -1, testStringTile) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.setTileAt(2, 0, testStringTile) }
        assertFailsWith(IndexOutOfBoundsException::class) { testBoard.setTileAt(0, 2, testStringTile) }
    }
}